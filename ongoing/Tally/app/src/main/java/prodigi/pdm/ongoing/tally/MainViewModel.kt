package prodigi.pdm.ongoing.tally

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import prodigi.pdm.ongoing.tally.domain.TallyCounter
import prodigi.pdm.ongoing.tally.domain.isAtCapacity
import prodigi.pdm.ongoing.tally.domain.isAtMinimum


/**
 * The main screen possible states
 */
sealed class MainScreenState(val counter: TallyCounter) {
    class AtMin(counter: TallyCounter): MainScreenState(counter)
    class Counting(counter: TallyCounter): MainScreenState(counter)
    class AtCapacity(counter: TallyCounter): MainScreenState(counter)
}


class MainViewModel : ViewModel() {

    private var _currentState: MainScreenState by
        mutableStateOf(value = MainScreenState.AtMin(TallyCounter(count = 0)))

    val currentState: MainScreenState
        get() = _currentState

    fun increment() {
        Log.v(TAG, "vm.increment in thread = ${Thread.currentThread().name}")
        val observedState = _currentState
        check(observedState !is MainScreenState.AtCapacity)

        val newCounter = TallyCounter(count = observedState.counter.count + 1)
        _currentState =
            if (newCounter.isAtCapacity()) MainScreenState.AtCapacity(counter = newCounter)
            else MainScreenState.Counting(counter = newCounter)
    }

    fun decrement() {
        Log.v(TAG, "vm.decrement in thread = ${Thread.currentThread().name}")
        val observedState = _currentState
        check(observedState !is MainScreenState.AtMin)

        val newCounter = TallyCounter(count = observedState.counter.count - 1)
        _currentState =
            if (newCounter.isAtMinimum()) MainScreenState.AtMin(counter = newCounter)
            else MainScreenState.Counting(counter = newCounter)
    }
}
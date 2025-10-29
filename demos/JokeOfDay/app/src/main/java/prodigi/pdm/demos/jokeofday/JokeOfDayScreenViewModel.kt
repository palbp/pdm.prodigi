package prodigi.pdm.demos.jokeofday

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Represents the state of the joke of day screen.
 */
sealed interface JokeOfDayScreenState {
    data object Idle : JokeOfDayScreenState
    data object Loading : JokeOfDayScreenState
    data class Success(val joke: Joke) : JokeOfDayScreenState
    data class Error(val exception: Throwable) : JokeOfDayScreenState
}

/**
 * ViewModel for the Joke of the Day screen.
 * @property jokeService The service to get the joke of the day.
 */
class JokeOfDayScreenViewModel(val jokeService: JokesService) : ViewModel() {

    companion object {
        /**
         * Returns a factory to create a [JokeOfDayScreenViewModel] with the provided [JokesService].
         * @param service The service to get the joke of the day.
         */
        fun getFactory(service: JokesService) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                if (modelClass.isAssignableFrom(JokeOfDayScreenViewModel::class.java)) {
                    JokeOfDayScreenViewModel(jokeService = service) as T
                }
                else throw kotlin.IllegalArgumentException("Unknown ViewModel class")
        }
    }

    private var state: JokeOfDayScreenState by mutableStateOf(value = JokeOfDayScreenState.Idle)
    val currentState: JokeOfDayScreenState
        get() = state

    /**
     * Fetches a new joke from the service and updates the screen state accordingly.
     */
    fun fetchJoke() {
        if (state is JokeOfDayScreenState.Loading) {
            return
        }

        viewModelScope.launch {
            state = try {
                state = JokeOfDayScreenState.Loading
                JokeOfDayScreenState.Success(joke = jokeService.fetchJoke())
            } catch (e: Exception) {
                JokeOfDayScreenState.Error(e)
            }
        }
    }

    /**
     * Resets the screen state back to idle when in the error state.
     */
    fun resetToIdle() {
        if (state is JokeOfDayScreenState.Error) {
            state = JokeOfDayScreenState.Idle
        }
    }
}


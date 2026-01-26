package prodigi.pdm.ongoing.tally

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.tally.domain.TallyCounter
import prodigi.pdm.ongoing.tally.ui.theme.TallyTheme
import prodigi.pdm.ongoing.tally.views.TallyAtCapacityView
import prodigi.pdm.ongoing.tally.views.TallyAtMinView
import prodigi.pdm.ongoing.tally.views.TallyCountingView

/**
 * The main screen of the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(vm: MainViewModel) {
    TallyTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
        ) { innerPadding ->
            when (val state = vm.currentState) {
                is MainScreenState.AtMin ->
                    TallyAtMinView(
                        counter = state.counter,
                        onIncrement = { vm.increment() },
                        modifier = Modifier.padding(innerPadding)
                    )
                is MainScreenState.Counting ->
                    TallyCountingView(
                        counter = state.counter,
                        onIncrement = { vm.increment() },
                        onDecrement = { vm.decrement() },
                        modifier = Modifier.padding(innerPadding)
                    )
                is MainScreenState.AtCapacity ->
                    TallyAtCapacityView(
                        counter = state.counter,
                        onDecrement = { vm.decrement() },
                        modifier = Modifier.padding(innerPadding)
                    )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(vm = MainViewModel())
}

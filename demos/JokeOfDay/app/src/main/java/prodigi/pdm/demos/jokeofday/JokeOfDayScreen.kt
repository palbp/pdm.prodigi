package prodigi.pdm.demos.jokeofday

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.demos.jokeofday.ui.ErrorAlert
import prodigi.pdm.demos.jokeofday.ui.theme.JokeOfDayTheme

@Composable
fun JokeOfDayScreen(viewModel: JokeOfDayScreenViewModel, onBackIntent: () -> Unit) {
    when (val state = viewModel.currentState) {
        is JokeOfDayScreenState.Idle -> IdleView(
            onFetchRequested = { viewModel.fetchJoke() },
            onBackRequested = onBackIntent
        )

        is JokeOfDayScreenState.Loading -> LoadingView()

        is JokeOfDayScreenState.Success -> SuccessView(
            joke = state.joke,
            onFetchRequested = { viewModel.fetchJoke() },
            onBackRequested = onBackIntent
        )

        is JokeOfDayScreenState.Error -> ErrorAlert(
            title = R.string.jokes_error_api_title,
            message = R.string.jokes_error_could_not_reach_api,
            buttonText = R.string.jokes_error_retry_button_text,
            onDismiss = { viewModel.resetToIdle() }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JokeOfDayScreenPreview() {
    JokeOfDayTheme {
        JokeOfDayScreen(
            viewModel = JokeOfDayScreenViewModel(jokeService = FakeJokesService()),
            onBackIntent = { }
        )
    }
}
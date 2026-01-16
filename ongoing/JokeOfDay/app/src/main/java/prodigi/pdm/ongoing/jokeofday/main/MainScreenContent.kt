package prodigi.pdm.ongoing.jokeofday.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prodigi.pdm.ongoing.jokeofday.R
import prodigi.pdm.ongoing.jokeofday.ui.theme.JokeOfDayTheme

@Composable
fun MainScreenContent(onAboutNavigate: () -> Unit = {}, onJokeNavigate: () -> Unit = {}) {
    JokeOfDayTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 32.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onAboutNavigate) {
                Text(text = stringResource(R.string.main_menu_about))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onJokeNavigate) {
                Text(text = stringResource(R.string.main_menu_joke))
            }
        }
    }
}

@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}

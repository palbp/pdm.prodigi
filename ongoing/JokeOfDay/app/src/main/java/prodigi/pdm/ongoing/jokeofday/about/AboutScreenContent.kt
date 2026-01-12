@file:OptIn(ExperimentalMaterial3Api::class)

package prodigi.pdm.ongoing.jokeofday.about

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prodigi.pdm.ongoing.jokeofday.R
import prodigi.pdm.ongoing.jokeofday.ui.theme.JokeOfDayTheme


const val youtubeChannelURL = "https://www.youtube.com/@ProfPauloPereira"
const val twitchChannelURL = "https://www.twitch.tv/paulo_pereira"
const val linkedInURL = "https://www.linkedin.com/in/palbp/"
const val emailURL = "mailto:paulo.pereira@isel.pt"

@Composable
fun AboutScreenContent(
    onOpenURL: (Uri) -> Unit = {},
    onSendEmail: (Uri) -> Unit = {},
    onBackNavigation: () -> Unit = {}
) {
    JokeOfDayTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.about_title)) },
                    navigationIcon = {
                        IconButton(onClick = onBackNavigation) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                )
            }
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                AuthorInfo(onSendEmail)
                Socials(onOpenURL)
            }
        }
    }
}

@Composable
private fun AuthorInfo(onSendEmail: (Uri) -> Unit = {}) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp)
    ) {
        Image(
            painterResource(R.drawable.ic_author),
            contentDescription = "Author Image",
            modifier = Modifier.size(128.dp).clickable {
                onSendEmail(Uri.parse(emailURL))
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Paulo Pereira",
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun Socials(onOpenURL: (Uri) -> Unit = {}) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(fraction = 0.3f)
    ) {
        Image(
            painterResource(R.drawable.ic_youtube),
            contentDescription = "YouTube Channel",
            modifier = Modifier.clickable {
                onOpenURL(Uri.parse(youtubeChannelURL))
            }
        )
        Image(
            painterResource(R.drawable.ic_twitch),
            contentDescription = "Twitch Channel",
            modifier = Modifier.clickable {
                onOpenURL(Uri.parse(twitchChannelURL))
            }
        )
        Image(
            painterResource(R.drawable.ic_linkedin),
            contentDescription = "Linked In",
            modifier = Modifier.clickable {
                onOpenURL(Uri.parse(linkedInURL))
            }
        )
    }
}

@Preview
@Composable
private fun AuthorInfoPreview() {
    JokeOfDayTheme {
        AuthorInfo()
    }
}

@Preview
@Composable
private fun SocialsPreview() {
    JokeOfDayTheme {
        Socials()
    }
}

@Preview
@Composable
private fun AboutScreenContentPreview() {
    AboutScreenContent()
}

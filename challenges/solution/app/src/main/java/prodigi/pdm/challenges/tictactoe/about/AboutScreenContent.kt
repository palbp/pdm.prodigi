package prodigi.pdm.challenges.tictactoe.about

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.ui.TopBarWithBackNavigation
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

/**
 * Data class representing social media information.
 * @param link The URI link to the social media profile.
 * @param imageId The drawable resource ID for the social media icon.
 */
data class SocialInfo(val link: Uri, @param:DrawableRes val imageId: Int)

/**
 * The content of the About screen.
 *
 * @param backRequested Callback to be invoked when the user requests to navigate back.
 * @param onSendEmailRequested Callback to be invoked when the user requests to send an email
 * @param onOpenUrlRequested Callback to be invoked when the user requests to open a URL.
 * @param socials The list of social media information to be displayed.
 */
@Composable
fun AboutScreenContent(
    backRequested: () -> Unit = { },
    onSendEmailRequested: () -> Unit = { },
    onOpenUrlRequested: (Uri) -> Unit = { },
    socials: Iterable<SocialInfo>,
) {
    TicTacToeTheme {
        Scaffold(
            topBar = {
                TopBarWithBackNavigation(
                    title = stringResource(id = R.string.about_screen_title),
                    onBackRequested = backRequested
                )
            }
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                Author(onSendEmailRequested)
                Spacer(modifier = Modifier.height(80.dp))
                Socials(socials = socials, onOpenUrlRequested)
            }
        }
    }
}

/**
 * Composable function to display the author's information.
 * @param onSendEmailRequested Callback to be invoked when the user requests to send an email.
 */
@Composable
fun Author(onSendEmailRequested: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_author),
            contentDescription = null,
            modifier = Modifier.sizeIn(100.dp, 100.dp, 200.dp, 200.dp)
        )
        Text(text = "Paulo Pereira", style = MaterialTheme.typography.bodyLarge)
        Icon(
            imageVector = Icons.Outlined.Email,
            contentDescription = "Send Email",
            modifier = Modifier.clickable { onSendEmailRequested() }
        )
    }
}

/**
 * Composable function to display a list of social media icons.
 * @param socials An iterable collection of SocialInfo objects representing social media links and icons.
 * @param onOpenUrlRequested Callback to be invoked when the user requests to open a URL.
 */
@Composable
fun Socials(
    socials: Iterable<SocialInfo>,
    onOpenUrlRequested: (Uri) -> Unit = { }
) {
    Column(
        modifier = Modifier.widthIn(min = 60.dp, max = 120.dp)
    ) {
        socials.forEach {
            Social(
                id = it.imageId,
                uri = it.link,
                onOpenUrlRequested = onOpenUrlRequested
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

/**
 * Composable function to display a social media icon.
 * @param id The drawable resource ID for the social media icon.
 * @param uri The URI link to the social media profile.
 * @param onOpenUrlRequested Callback to be invoked when the user requests to open the URL
 */
@Composable
fun Social(
    @DrawableRes id: Int,
    uri: Uri,
    onOpenUrlRequested: (Uri) -> Unit
) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier.clickable {  onOpenUrlRequested(uri) }
    )
}

@Preview(showBackground = true)
@Composable
private fun AboutScreenContentPreview() {
    val socialsPreview = listOf(
        SocialInfo(
            link = "https://www.linkedin.com/in/palbp/".toUri(),
            imageId = R.drawable.ic_linkedin
        ),
    )
    AboutScreenContent(socials = socialsPreview)
}

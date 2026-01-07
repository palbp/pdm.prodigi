package prodigi.pdm.challenges.tictactoe.about

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.utils.LoggingActivity

/**
 * The Activity that shows information about the app. For now it is simply a placeholder.
 */
class AboutActivity : LoggingActivity() {

    companion object {

        /**
         * Creates a new intent used to navigate to the AboutActivity.
         * @param origin The activity from which the navigation is triggered. Because all our
         * activities inherit from LoggingActivity, we can use it the parameter type.
         */
        fun newIntent(origin: LoggingActivity) =
            Intent(origin, AboutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutScreenContent(
                backRequested = { finish() },
                socials = authorSocials
            )
        }
    }
}

private val authorSocials = listOf(
    SocialInfo(
        link = "https://www.linkedin.com/in/palbp/".toUri(),
        imageId = R.drawable.ic_linkedin
    ),
    SocialInfo(
        link = "https://www.twitch.tv/paulo_pereira".toUri(),
        imageId = R.drawable.ic_twitch
    ),
    SocialInfo(
        link = "https://www.youtube.com/channel/UCetmdF6qGnMAdZP32i8AnbA".toUri(),
        imageId = R.drawable.ic_youtube
    )
)


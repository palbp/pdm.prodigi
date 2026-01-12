package prodigi.pdm.challenges.tictactoe.about

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.utils.LoggingActivity


private const val ABOUT_TAG = "AboutActivity"

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
                onSendEmailRequested = { openSendEmail() },
                onOpenUrlRequested = { url -> openURL(url) },
                socials = authorSocials
            )
        }
    }

    private fun openSendEmail() {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(authorEmail))
                putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            }

            startActivity(intent)
        }
        catch (e: ActivityNotFoundException) {
            Log.e(ABOUT_TAG, "Failed to send email", e)
            Toast
                .makeText(
                    this,
                    R.string.about_screen_no_suitable_app,
                    Toast.LENGTH_LONG
                )
                .show()
        }
    }

    private fun openURL(url: Uri) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, url)
            startActivity(intent)
        }
        catch (e: ActivityNotFoundException) {
            Log.e(ABOUT_TAG, "Failed to open URL", e)
            Toast
                .makeText(
                    this,
                    R.string.about_screen_no_suitable_app,
                    Toast.LENGTH_LONG
                )
                .show()
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
        link = "https://www.youtube.com/@ProfPauloPereira".toUri(),
        imageId = R.drawable.ic_youtube
    )
)

private const val authorEmail = "paulo.pereira@isel.pt"
private const val emailSubject = "About the Tic-Tac-Toe Demo App"


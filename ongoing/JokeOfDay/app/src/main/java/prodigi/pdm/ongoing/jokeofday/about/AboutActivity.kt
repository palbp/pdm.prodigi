package prodigi.pdm.ongoing.jokeofday.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class AboutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutScreenContent(
                onSendEmail = { uri -> sendEmail(uri) },
                onOpenURL = { uri -> openURL(uri) },
                onBackNavigation = { finish() }
            )
        }
    }

    private fun sendEmail(uri: Uri) {
        Log.v("AboutActivity", "sendEmail to: $uri")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        startActivity(intent)
    }

    private fun openURL(uri: Uri) {
        Log.v("AboutActivity", "openURL: $uri")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
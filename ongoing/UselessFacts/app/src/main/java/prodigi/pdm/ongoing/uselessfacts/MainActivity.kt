package prodigi.pdm.ongoing.uselessfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import prodigi.pdm.ongoing.uselessfacts.ui.FactScreen
import prodigi.pdm.ongoing.uselessfacts.ui.theme.UselessFactsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: FactViewModel by viewModels {
        val theApplication = application as UselessFactsApplication
        FactViewModel.factory(theApplication.service)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UselessFactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FactScreen(
                        state = viewModel.state,
                        onRequestNextFact = { viewModel.fetchFact() },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

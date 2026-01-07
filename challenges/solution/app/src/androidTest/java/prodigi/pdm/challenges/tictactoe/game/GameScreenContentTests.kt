package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import prodigi.pdm.challenges.tictactoe.about.AboutScreenContent
import prodigi.pdm.challenges.tictactoe.ui.TOP_BAR_BACK_BUTTON_TEST_TAG

@OptIn(ExperimentalTestApi::class)
class GameScreenContentTests {

    @Test
    fun backRequested_is_called_when_back_navigation_button_is_pressed() = runComposeUiTest {
        var backRequestedCalled = false
        setContent {
            AboutScreenContent(
                backRequested = { backRequestedCalled = true },
                socials = emptyList()
            )
        }

        onNodeWithTag(testTag = TOP_BAR_BACK_BUTTON_TEST_TAG).performClick()
        assert(value = backRequestedCalled) {
            "Expected backRequestedCalled to be called when back button is pressed."
        }
    }
}
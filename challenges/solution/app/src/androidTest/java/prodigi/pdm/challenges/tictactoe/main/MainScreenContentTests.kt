package prodigi.pdm.challenges.tictactoe.main

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import prodigi.pdm.challenges.tictactoe.about.AboutScreenContent
import prodigi.pdm.challenges.tictactoe.ui.TOP_BAR_BACK_BUTTON_TEST_TAG

@OptIn(ExperimentalTestApi::class)
class MainScreenContentTests {

    @Test
    fun aboutRequested_is_called_when_about_button_is_pressed() = runComposeUiTest {
        var aboutRequestedCalled = false
        setContent {
            MainScreenContent(
                aboutRequested = { aboutRequestedCalled = true }
            )
        }

        onNodeWithTag(testTag = MAIN_SCREEN_ABOUT_BUTTON_TAG).performClick()
        assert(value = aboutRequestedCalled) {
            "Expected aboutRequestedCalled to be called when About button is pressed."
        }
    }

    @Test
    fun playRequested_is_called_when_play_button_is_pressed() = runComposeUiTest {
        var playRequestedCalled = false
        setContent {
            MainScreenContent(
                playRequested = { playRequestedCalled = true }
            )
        }

        onNodeWithTag(testTag = MAIN_SCREEN_PLAY_BUTTON_TAG).performClick()
        assert(value = playRequestedCalled) {
            "Expected playRequestedCalled to be called when Play button is pressed."
        }
    }
}
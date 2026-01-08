package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.ui.GAME_SCREEN_RESTART_GAME_BUTTON_TAG
import prodigi.pdm.challenges.tictactoe.game.ui.getBoardTileTag
import prodigi.pdm.challenges.tictactoe.ui.TOP_BAR_BACK_BUTTON_TEST_TAG

@OptIn(ExperimentalTestApi::class)
class GameActivityTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<GameActivity>()

    @Test
    fun activity_finishes_when_back_button_is_pressed() {

        composeTestRule
            .onNodeWithTag(TOP_BAR_BACK_BUTTON_TEST_TAG)
            .performClick()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            assert(activity.isFinishing)
        }
    }

    @Test
    fun game_restarts_when_restart_button_is_pressed() {

        val at = Coordinate(row = 0, column = 0)
        val sutTag = getBoardTileTag(at)
        composeTestRule
            .onNodeWithTag(testTag = sutTag)
            .performClick()

        // Verify that the tile has a marker and therefore is not enabled
        composeTestRule
            .onNodeWithTag(testTag = sutTag)
            .assertIsNotEnabled()

        composeTestRule
            .onNodeWithTag(GAME_SCREEN_RESTART_GAME_BUTTON_TAG)
            .performClick()

        // Verify that the tile is enabled again after restarting the game (it is empty)
        composeTestRule
            .onNodeWithTag(testTag = sutTag)
            .assertIsEnabled()
    }

    @Test
    fun clicking_an_empty_tile_makes_a_move() {

        val at = Coordinate(row = 1, column = 1)
        val sutTag = getBoardTileTag(at)
        composeTestRule
            .onNodeWithTag(testTag = sutTag)
            .performClick()

        // Verify that the tile is not enabled after being clicked (it has a marker now)
        composeTestRule
            .onNodeWithTag(testTag = sutTag)
            .assertIsNotEnabled()
    }
}
package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.domain.Game
import prodigi.pdm.challenges.tictactoe.game.domain.Marker
import prodigi.pdm.challenges.tictactoe.game.ui.GAME_SCREEN_GAME_STATE_MESSAGE_TAG
import prodigi.pdm.challenges.tictactoe.game.ui.GAME_SCREEN_RESTART_GAME_BUTTON_TAG
import prodigi.pdm.challenges.tictactoe.game.ui.GameScreenContent
import prodigi.pdm.challenges.tictactoe.game.ui.getBoardTileTag
import prodigi.pdm.challenges.tictactoe.getEnglishContext
import prodigi.pdm.challenges.tictactoe.ui.TOP_BAR_BACK_BUTTON_TEST_TAG

@OptIn(ExperimentalTestApi::class)
class GameScreenContentTests {

    @Test
    fun backRequested_is_called_when_back_navigation_button_is_pressed() = runComposeUiTest {
        var backRequestedCalled = false
        setContent {
            GameScreenContent(
                game = Game(),
                backRequested = { backRequestedCalled = true },
            )
        }

        onNodeWithTag(testTag = TOP_BAR_BACK_BUTTON_TEST_TAG).performClick()
        assert(value = backRequestedCalled) {
            "Expected backRequestedCalled to be called when back button is pressed."
        }
    }

    @Test
    fun restartGameRequested_is_called_when_restart_game_button_is_pressed() = runComposeUiTest {
        var restartGameRequestedCalled = false
        setContent {
            GameScreenContent(
                game = Game(),
                restartGameRequested = { restartGameRequestedCalled = true }
            )
        }

        onNodeWithTag(testTag = GAME_SCREEN_RESTART_GAME_BUTTON_TAG).performClick()
        assert(value = restartGameRequestedCalled) {
            "Expected restartGameRequestedCalled to be called when restart game button is pressed."
        }
    }

    @Test
    fun makeMoveRequested_is_called_when_a_tile_is_pressed() = runComposeUiTest {
        var makeMoveRequestedCalled: Coordinate? = null
        setContent {
            GameScreenContent(
                game = Game(),
                makeMoveRequested = { makeMoveRequestedCalled = it }
            )
        }

        val expectedCoordinate = Coordinate(row = 0, column = 0)
        onNodeWithTag(testTag = getBoardTileTag(at = expectedCoordinate)).performClick()
        assert(value = makeMoveRequestedCalled == expectedCoordinate) {
            "Expected makeMoveRequestedCalled to be called with correct coordinates when a board tile is pressed."
        }
    }

    @Test
    fun makeMoveRequested_is_not_called_when_a_marked_tile_is_pressed() = runComposeUiTest {
        var makeMoveRequestedCalled: Coordinate? = null
        val gameWithMarkedTile = Game().makeMove(at = Coordinate(row = 0, column = 0))
        setContent {
            GameScreenContent(
                game = gameWithMarkedTile,
                makeMoveRequested = { makeMoveRequestedCalled = it }
            )
        }

        onNodeWithTag(testTag = getBoardTileTag(at = Coordinate(row = 0, column = 0))).performClick()
        assert(value = makeMoveRequestedCalled == null) {
            "Expected makeMoveRequestedCalled to not be called when a marked tile is pressed."
        }
    }

    @Test
    fun makeMoveRequested_is_not_called_when_game_is_over_and_a_tile_is_pressed() = runComposeUiTest {
        var makeMoveRequestedCalled: Coordinate? = null
        val gameOverGame = Game().makeMove(at = Coordinate(row = 0, column = 0))
            .makeMove(at = Coordinate(row = 1, column = 0))
            .makeMove(at = Coordinate(row = 0, column = 1))
            .makeMove(at = Coordinate(row = 1, column = 1))
            .makeMove(at = Coordinate(row = 0, column = 2)) // X wins
        setContent {
            GameScreenContent(
                game = gameOverGame,
                makeMoveRequested = { makeMoveRequestedCalled = it }
            )
        }

        onNodeWithTag(testTag = getBoardTileTag(at = Coordinate(row = 2, column = 2))).performClick()
        assert(value = makeMoveRequestedCalled == null) {
            "Expected makeMoveRequestedCalled to not be called when the game is over and a tile is pressed."
        }
    }

    @Test
    fun tied_game_message_is_correctly_displayed() = runComposeUiTest {
        val tiedGame = Game(
            board = listOf(
                listOf(Marker.CROSS, Marker.CIRCLE, Marker.CROSS),
                listOf(Marker.CROSS, Marker.CIRCLE, Marker.CIRCLE),
                listOf(Marker.CIRCLE, Marker.CROSS, Marker.CROSS),
            ),
        )

        val englishContext = getEnglishContext()
        val expectedTiedMessage = englishContext.getString(
            R.string.game_screen_draw_message
        )

        setContent {
            CompositionLocalProvider(LocalContext provides englishContext) {
                GameScreenContent(
                    game = tiedGame,
                )
            }
        }

        onNodeWithTag(GAME_SCREEN_GAME_STATE_MESSAGE_TAG)
            .assertTextContains(expectedTiedMessage)
    }

    @Test
    fun winning_game_message_is_correctly_displayed() = runComposeUiTest {
        val winningGame = Game(
            board = listOf(
                listOf(Marker.CROSS, Marker.CROSS, Marker.CROSS),
                listOf(Marker.CIRCLE, Marker.CIRCLE, null),
                listOf(null, null, null),
            ),
        )

        val englishContext = getEnglishContext()
        val expectedWinningMessage = englishContext.getString(
            R.string.game_screen_winner_message,
            Marker.CROSS
        )

        setContent {
            CompositionLocalProvider(LocalContext provides englishContext) {
                GameScreenContent(
                    game = winningGame,
                )
            }
        }

        onNodeWithTag(GAME_SCREEN_GAME_STATE_MESSAGE_TAG)
            .assertTextContains(expectedWinningMessage)
    }

    @Test
    fun ongoing_game_message_is_correctly_displayed() = runComposeUiTest {
        val ongoingGame = Game(
            board = listOf(
                listOf(Marker.CROSS, Marker.CIRCLE, null),
                listOf(null, Marker.CROSS, null),
                listOf(null, null, Marker.CIRCLE),
            ),
            turn = Marker.CROSS
        )

        val englishContext = getEnglishContext()
        val expectedOngoingMessage = englishContext.getString(
            R.string.game_screen_player_turn_message,
            Marker.CROSS.toString()
        )

        setContent {
            CompositionLocalProvider(LocalContext provides englishContext) {
                GameScreenContent(
                    game = ongoingGame,
                )
            }
        }

        onNodeWithTag(GAME_SCREEN_GAME_STATE_MESSAGE_TAG)
            .assertTextContains(expectedOngoingMessage)
    }
}
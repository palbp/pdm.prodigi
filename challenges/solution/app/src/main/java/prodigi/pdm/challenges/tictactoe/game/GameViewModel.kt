package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.domain.Game

/**
 * The ViewModel for the Game screen.
 */
class GameViewModel : ViewModel() {


    /**
     * The current game state.
     */
    var game by mutableStateOf(Game())
        private set

    /**
     * Starts a new game.
     * If a game is currently in progress, it will be restarted.
     */
    fun startGame() {
        game = Game()
    }

    /**
     * Makes a move at the given position.
     * @param at The position where to make the move.
     */
    fun makeMove(at: Coordinate) {
        game = game.makeMove(at)
    }
}
package prodigi.pdm.challenges.tictactoe.game.domain

/**
 * Represents a Tic-Tac-Toe board. Instances are immutable.
 * @property turn   The next player to move
 * @property board  The board tiles
 */
data class Game(
    val turn: Marker = Marker.firstToMove,
    val board: List<List<Marker?>> =
        List(
            size = BOARD_SIDE,
            init = { List(size = BOARD_SIDE, init = { null }) }
        )
) {

    /**
     * Overloads the indexing operator
     */
    operator fun get(at: Coordinate): Marker? = getMove(at)

    /**
     * Gets the move at the given coordinates.
     * @param at    the move's coordinates
     * @return the [Marker] instance that made the move, or null if the position is empty
     */
    fun getMove(at: Coordinate): Marker? = board[at.row][at.column]

    /**
     * Makes a move at the given coordinates and returns the new game instance.
     * @param at    the board's coordinate
     * @throws IllegalArgumentException if the position is already occupied
     * @return the new board instance
     */
    fun makeMove(at: Coordinate): Game {
        check(this[at] == null)
        return Game(
            turn = turn.other,
            board = board.mapIndexed { row, elem ->
                if (row == at.row)
                    List(board[row].size) { col ->
                        if (col == at.column) turn
                        else board[row][col]
                    }
                else
                    elem

            }
        )
    }

    /**
     * Converts this instance to a list of moves.
     */
    fun toMovesList(): List<Marker?> = board.flatten()
}

/**
 * Extension function that checks whether this game represents a tied game or not
 * @return true if the game is , false otherwise
 */
fun Game.isTied(): Boolean =
    toMovesList().all { it != null } && !hasWon(Marker.CIRCLE) && !hasWon(Marker.CROSS)

/**
 * Extension function that checks whether the given marker has won the game
 * @return true if the player with the given marker has won, false otherwise
 */
fun Game.hasWon(marker: Marker): Boolean =
    board.any { row -> row.all { it == marker } } ||
            (0 until BOARD_SIDE).any { column ->
                (0 until BOARD_SIDE).all { row -> board[row][column] == marker }
            } ||
            board[0][0] == marker && board[1][1] == marker && board[2][2] == marker ||
            board[0][2] == marker && board[1][1] == marker && board[2][0] == marker


/**
 * Represents the result of a Tic-Tac-Toe game.
 */
sealed interface GameResult {
    data class HasWinner(val winner: Marker) : GameResult
    object Tied : GameResult
    object OnGoing : GameResult
}

/**
 * Gets the current result of this game.
 */
fun Game.getResult(): GameResult =
    when {
        hasWon(Marker.CIRCLE) -> GameResult.HasWinner(Marker.CIRCLE)
        hasWon(Marker.CROSS) -> GameResult.HasWinner(Marker.CROSS)
        isTied() -> GameResult.Tied
        else -> GameResult.OnGoing
    }
package prodigi.pdm.challenges.tictactoe.game.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test


class GameTests {

    @Test
    fun `newly created game has no moves`() {
        val sut = Game()
        assert(sut.toMovesList().all { it == null }) {
            "Expected all tiles to be empty on a newly created game."
        }
    }

    @Test
    fun `turn on a newly created game is the first to move`() {
        val sut = Game()
        assert(sut.turn == Marker.firstToMove) {
            "Expected turn to be the first to move on a newly created game."
        }
    }

    @Test
    fun `making a move on an empty tile succeeds and changes turn`() {
        // Arrange
        val at = Coordinate(row = 1, column = 2)
        val sut = Game()
        val firstTurn = sut.turn

        // Act
        val gameAfterMove = sut.makeMove(at)

        // Assert
        val move = gameAfterMove.getMove(at)
        assertNotNull(move)
        assertEquals(firstTurn, move)
        assertNotEquals(firstTurn, gameAfterMove.turn)
    }

    @Test(expected = IllegalStateException::class)
    fun `making a move on a non empty tile throws`() {
        // Arrange
        val at = Coordinate(row = 0, column = 0)
        val sut = Game().makeMove(at)

        // Act
        sut.makeMove(at)
    }

    @Test
    fun `hasWon returns true when row has the same marker in all tiles`() {

        val sut = Game(
            turn = Marker.CROSS,
            board = listOf(
                listOf(null, Marker.CROSS, Marker.CROSS),
                buildList { Marker.CIRCLE },
                listOf(Marker.CROSS, null, null)
            )
        )

        assert(sut.hasWon(Marker.CIRCLE)) {
            "Expected CIRCLE to have won with a complete row."
        }
    }

    @Test
    fun `hasWon returns true when column has the same marker in all tiles`() {

        val sut = Game(
            turn = Marker.CIRCLE,
            board = listOf(
                listOf(null, Marker.CROSS, Marker.CIRCLE),
                listOf(null, Marker.CROSS, Marker.CIRCLE),
                listOf(Marker.CIRCLE, Marker.CROSS, null)
            )
        )

        assert(sut.hasWon(Marker.CROSS)) {
            "Expected CROSS to have won with a complete column."
        }
    }

    @Test
    fun `hasWon returns true when diagonal has the same marker in all tiles`() {

        val sut = Game(
            turn = Marker.CIRCLE,
            board = listOf(
                listOf(Marker.CROSS, null, Marker.CIRCLE),
                listOf(null, Marker.CROSS, Marker.CIRCLE),
                listOf(Marker.CIRCLE, null, Marker.CROSS)
            )
        )

        assert(sut.hasWon(Marker.CROSS)) {
            "Expected CROSS to have won with a complete diagonal."
        }
    }

    @Test
    fun `hasWon returns false when no winner is found`() {

        val sut = Game(
            turn = Marker.CIRCLE,
            board = listOf(
                listOf(null, null, Marker.CIRCLE),
                listOf(null, Marker.CROSS, null),
                listOf(null, null, null)
            )
        )

        assertFalse(sut.hasWon(Marker.CROSS))
        assertFalse(sut.hasWon(Marker.CIRCLE))
    }

    @Test
    fun `isTied returns true when no winner is found and board is complete`() {

        val sut = Game(
            turn = Marker.CROSS,
            board = listOf(
                listOf(Marker.CIRCLE, Marker.CROSS, Marker.CIRCLE),
                listOf(Marker.CIRCLE, Marker.CROSS, Marker.CROSS),
                listOf(Marker.CROSS, Marker.CIRCLE, Marker.CIRCLE)
            )
        )

        assert(sut.isTied()) {
            "Expected the game to be tied."
        }
    }

    @Test
    fun `getResult returns HasWinner with winner marker when there is one winner`() {
        val sut = Game(
            turn = Marker.CIRCLE,
            board = listOf(
                listOf(Marker.CROSS, null, Marker.CIRCLE),
                listOf(null, Marker.CROSS, Marker.CIRCLE),
                listOf(Marker.CIRCLE, null, Marker.CROSS)
            )
        )

        val result = sut.getResult() as? GameResult.HasWinner
        assert(result?.winner == Marker.CROSS) {
            "Expected the winner to be CROSS."
        }
    }

    @Test
    fun `getResult returns Tied when the game is tied`() {
        val sut = Game(
            turn = Marker.CROSS,
            board = listOf(
                listOf(Marker.CIRCLE, Marker.CROSS, Marker.CIRCLE),
                listOf(Marker.CIRCLE, Marker.CROSS, Marker.CROSS),
                listOf(Marker.CROSS, Marker.CIRCLE, Marker.CIRCLE)
            )
        )

        val result = sut.getResult() as? GameResult.Tied
        assert(result != null) {
            "Expected the game to be tied."
        }
    }

    @Test
    fun `getResult returns NotFinished when there is no winner and the board is not yet complete`() {
        val sut = Game(
            turn = Marker.CIRCLE,
            board = listOf(
                listOf(null, null, Marker.CIRCLE),
                listOf(null, Marker.CROSS, null),
                listOf(null, null, null)
            )
        )

        val result = sut.getResult() as? GameResult.OnGoing
        assert(result != null) {
            "Expected the game to be ongoing."
        }
    }
}
package prodigi.pdm.challenges.tictactoe.game.domain

import org.junit.Assert.assertFalse
import org.junit.Test

class CoordinatesTests {

    @Test
    fun `isValidRow returns true when in the board bounds indexes`() {
        assert(isValidRow(2)) {
            "Expected row index 2 to be valid"
        }
    }

    @Test
    fun `isValidRow returns false for negative index`() {
        assertFalse(isValidRow(-2))
    }

    @Test
    fun `isValidColumn returns true when in the board bounds indexes`() {
        assert(isValidColumn(0) ) {
            "Expected column index 0 to be valid"
        }
    }

    @Test
    fun `isValidColumn returns false for negative index`() {
        assertFalse(isValidRow(-1))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `create Coordinate with invalid row throws`() {
        Coordinate(row = -2, column = 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `create Coordinate with invalid column throws`() {
        Coordinate(row = 2, column = -3)
    }

    @Test
    fun `create Coordinate with valid coordinates succeeds`() {
        Coordinate(row = 2, column = 1)
    }
}

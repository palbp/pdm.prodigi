package prodigi.pdm.challenges.tictactoe.game.domain

import org.junit.Test


class MarkerTests {

    @Test
    fun `first to play is CIRCLE`() {
        val sut = Marker.firstToMove
        assert(sut == Marker.CIRCLE) {
            "First player to move always uses the circle marker"
        }
    }

    @Test
    fun `other player is CROSS`() {
        val sut = Marker.firstToMove.other
        assert(sut == Marker.CROSS) {
            "From the first to move, the other player marker should be the cross"
        }
    }


    @Test
    fun `toString on CROSS returns X`() {
        val sut = Marker.CROSS.toString()
        assert(sut == "X") {
            "Marker CROSS should return X when toString is called"
        }
    }

    @Test
    fun `toString on CIRCLE returns O`() {
        val sut = Marker.CIRCLE.toString()
        assert(sut == "O") {
            "Marker CIRCLE should return O when toString is called"
        }
    }
}
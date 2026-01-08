package prodigi.pdm.challenges.tictactoe.game.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.game.domain.BOARD_SIDE
import prodigi.pdm.challenges.tictactoe.game.domain.Game
import prodigi.pdm.challenges.tictactoe.game.domain.GameResult
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.domain.Marker
import prodigi.pdm.challenges.tictactoe.game.domain.getResult
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

/**
 * Generates a test tag for a board tile at the given row and column.
 * @param at The coordinate of the board tile.
 * @return The test tag for the board tile.
 */
fun getBoardTileTag(at: Coordinate) = "BoardTile_${at.row}_${at.column}"

/**
 * A composable that represents the Tic Tac Toe board.
 * @param game The current game state.
 * @param modifier The modifier to be applied to the board.
 */
@Composable
fun BoardView(
    game: Game,
    onTileSelected: (at: Coordinate) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        repeat(BOARD_SIDE) { row ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1.0f, fill = true)
            ) {
                repeat(BOARD_SIDE) { column ->
                    val at = Coordinate(row, column)
                    TileView(
                        marker = game[at],
                        enabled = game.getResult() is GameResult.OnGoing && game[at] == null,
                        onSelected = { onTileSelected(at) },
                        modifier = Modifier
                            .weight(weight = 1.0f, fill = true)
                            .testTag(tag = getBoardTileTag(at)),
                    )
                    if (column != BOARD_SIDE - 1) { VerticalSeparator() }
                }
            }
            if (row != BOARD_SIDE - 1) { HorizontalSeparator() }
        }
    }
}

/**
 * Used to draw the board horizontal lines.
 */
@Composable
private fun HorizontalSeparator() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(8.dp)
        .background(MaterialTheme.colorScheme.primary)
    )
}

/**
 * Used to draw the board vertical lines.
 */
@Composable
private fun VerticalSeparator() {
    Spacer(modifier = Modifier
        .fillMaxHeight()
        .width(8.dp)
        .background(MaterialTheme.colorScheme.primary)
    )
}


@Preview(showBackground = true)
@Composable
private fun EmptyBoardViewPreview() {
    TicTacToeTheme {
        BoardView(game = Game(), onTileSelected = { })
    }
}

@Preview(showBackground = true)
@Composable
private fun NonEmptyBoardViewPreview() {
    TicTacToeTheme {
        BoardView(game = aGame, onTileSelected = { })
    }
}

private val aGame = Game(
    turn = Marker.CIRCLE,
    board = listOf(
        listOf(Marker.CROSS, null, Marker.CIRCLE),
        listOf(null, Marker.CROSS, Marker.CIRCLE),
        listOf(Marker.CIRCLE, null, Marker.CROSS)
    )
)

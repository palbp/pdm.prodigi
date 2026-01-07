package prodigi.pdm.challenges.tictactoe.game

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

const val BOARD_SIDE = 3

/**
 * A composable that represents the Tic Tac Toe board.
 * @param modifier The modifier to be applied to the board.
 *
 * NOTE: This is currently an empty placeholder composable with empty tiles.
 */
@Composable
fun BoardView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        repeat(BOARD_SIDE) { row ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1.0f, fill = true)
            ) {
                repeat(BOARD_SIDE) { column ->
                    TileView(modifier = Modifier.weight(weight = 1.0f, fill = true))
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
        BoardView()
    }
}

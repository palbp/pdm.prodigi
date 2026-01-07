package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A single tile view for the Tic Tac Toe game.
 * @param modifier The modifier to be applied to the tile.
 *
 * NOTE: This is currently an empty placeholder composable.
 */
@Composable
fun TileView(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize(1.0f)
        .padding(12.dp)
    )
}

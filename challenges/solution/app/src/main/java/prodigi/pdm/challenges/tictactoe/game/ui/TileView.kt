package prodigi.pdm.challenges.tictactoe.game.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.game.domain.Marker
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

/**
 * A single tile view for the Tic Tac Toe game.
 * @param marker The marker to be displayed in the tile.
 * @param enabled Whether the tile is enabled for selection.
 * @param modifier The modifier to be applied to the tile.
 */
@Composable
fun TileView(
    marker: Marker?,
    enabled: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxSize(fraction = 1.0f)
        .padding(all = 12.dp)
        .clickable(enabled = marker == null && enabled) { onSelected() }
    ) {
        marker?.let {
            Image(
                painter = painterResource(id =
                    if (it == Marker.CIRCLE) R.drawable.circle_red
                    else R.drawable.cross_red
                ),
                contentDescription = marker.name,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TileViewCirclePreview() {
    TicTacToeTheme {
        TileView(marker = Marker.CIRCLE, enabled = true, onSelected = { })
    }
}


@Preview(showBackground = true)
@Composable
private fun TileViewCrossPreview() {
    TicTacToeTheme {
        TileView(marker = Marker.CROSS, enabled = true, onSelected = { })
    }
}

@Preview(showBackground = true)
@Composable
private fun TileViewEmptyPreview() {
    TicTacToeTheme {
        TileView(marker = null, enabled = true, onSelected = { })
    }
}
package prodigi.pdm.ongoing.tally.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.tally.domain.TallyCounter

@Composable
fun TallyCountingView(
    counter: TallyCounter,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    TallyView(
        counter,
        onIncrement,
        onDecrement,
        modifier
    )
}

@Preview
@Composable
fun TallyCountingViewPreview() {
    TallyCountingView(
        counter = TallyCounter(4),
        onIncrement = {},
        onDecrement = {}
    )
}
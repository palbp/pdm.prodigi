package prodigi.pdm.ongoing.tally

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.tally.domain.TallyCounter

@Composable
fun TallyAtMinView(
    counter: TallyCounter,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TallyView(counter, onIncrement = onIncrement, modifier = modifier)
}

@Preview
@Composable
fun TallyAtMinViewPreview() {
    TallyAtMinView(
        counter = TallyCounter(0),
        onIncrement = { }
    )
}
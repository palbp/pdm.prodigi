package prodigi.pdm.ongoing.tally

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.tally.domain.TallyCounter

@Composable
fun TallyAtCapacityView(
    counter: TallyCounter,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TallyView(counter, onDecrement = onDecrement, modifier = modifier)
}

@Preview
@Composable
fun TallyAtCapacityViewPreview() {
    TallyAtCapacityView(
        counter = TallyCounter(0),
        onDecrement = { }
    )
}
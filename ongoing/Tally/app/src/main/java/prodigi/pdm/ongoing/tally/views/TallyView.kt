package prodigi.pdm.ongoing.tally.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prodigi.pdm.ongoing.tally.domain.TallyCounter
import prodigi.pdm.ongoing.tally.ui.TallyCounterButton


typealias ButtonHandler = () -> Unit

@Composable
fun TallyView(
    counter: TallyCounter,
    onIncrement: ButtonHandler? = null,
    onDecrement: ButtonHandler? = null,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = counter.count.toString(),
            fontSize = 82.sp
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            TallyCounterButton(
                text = "-",
                enabled = onDecrement != null,
                onClick = onDecrement?: {}
            )
            Spacer(modifier = Modifier.width(16.dp))
            TallyCounterButton(
                enabled = onIncrement != null,
                text = "+",
                onClick = onIncrement?: {}
            )
        }
    }
}

@Preview
@Composable
fun TallyViewPreview() {
    TallyView(
        counter = TallyCounter(1),
        onIncrement = {},
        onDecrement = {}
    )

}
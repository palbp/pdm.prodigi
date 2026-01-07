package prodigi.pdm.challenges.tictactoe.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign

const val TOP_BAR_BACK_BUTTON_TEST_TAG = "TopBarWithBackNavigation_BackButton"

/**
 * A top bar with a back navigation icon and a title. It is intended to be used
 * as the top bar of a Scaffold in the screens of the application that support back navigation.
 * @param title The title to be displayed in the top bar.
 * @param onBackRequested Callback to be invoked when the user requests to navigate back.
 */
@Composable
fun TopBarWithBackNavigation(
    title: String,
    onBackRequested: () -> Unit
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.fillMaxWidth().statusBarsPadding()
    ) {
        IconButton(
            onClick = onBackRequested,
            modifier = Modifier.testTag(TOP_BAR_BACK_BUTTON_TEST_TAG)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}
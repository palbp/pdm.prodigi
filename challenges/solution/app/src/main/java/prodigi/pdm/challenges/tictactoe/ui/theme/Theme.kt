@file:Suppress("Unused", "DuplicatedCode")

package prodigi.pdm.challenges.tictactoe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import demos.tds.tictactoe.common.ui.theme.backgroundDark
import demos.tds.tictactoe.common.ui.theme.backgroundLight
import demos.tds.tictactoe.common.ui.theme.errorContainerDark
import demos.tds.tictactoe.common.ui.theme.errorContainerLight
import demos.tds.tictactoe.common.ui.theme.errorDark
import demos.tds.tictactoe.common.ui.theme.errorLight
import demos.tds.tictactoe.common.ui.theme.inverseOnSurfaceDark
import demos.tds.tictactoe.common.ui.theme.inverseOnSurfaceLight
import demos.tds.tictactoe.common.ui.theme.inversePrimaryDark
import demos.tds.tictactoe.common.ui.theme.inversePrimaryLight
import demos.tds.tictactoe.common.ui.theme.inverseSurfaceDark
import demos.tds.tictactoe.common.ui.theme.inverseSurfaceLight
import demos.tds.tictactoe.common.ui.theme.onBackgroundDark
import demos.tds.tictactoe.common.ui.theme.onBackgroundLight
import demos.tds.tictactoe.common.ui.theme.onErrorContainerDark
import demos.tds.tictactoe.common.ui.theme.onErrorContainerLight
import demos.tds.tictactoe.common.ui.theme.onErrorDark
import demos.tds.tictactoe.common.ui.theme.onErrorLight
import demos.tds.tictactoe.common.ui.theme.onPrimaryContainerDark
import demos.tds.tictactoe.common.ui.theme.onPrimaryContainerLight
import demos.tds.tictactoe.common.ui.theme.onPrimaryDark
import demos.tds.tictactoe.common.ui.theme.onPrimaryLight
import demos.tds.tictactoe.common.ui.theme.onSecondaryContainerDark
import demos.tds.tictactoe.common.ui.theme.onSecondaryContainerLight
import demos.tds.tictactoe.common.ui.theme.onSecondaryDark
import demos.tds.tictactoe.common.ui.theme.onSecondaryLight
import demos.tds.tictactoe.common.ui.theme.onSurfaceDark
import demos.tds.tictactoe.common.ui.theme.onSurfaceLight
import demos.tds.tictactoe.common.ui.theme.onSurfaceVariantDark
import demos.tds.tictactoe.common.ui.theme.onSurfaceVariantLight
import demos.tds.tictactoe.common.ui.theme.onTertiaryContainerDark
import demos.tds.tictactoe.common.ui.theme.onTertiaryContainerLight
import demos.tds.tictactoe.common.ui.theme.onTertiaryDark
import demos.tds.tictactoe.common.ui.theme.onTertiaryLight
import demos.tds.tictactoe.common.ui.theme.outlineDark
import demos.tds.tictactoe.common.ui.theme.outlineLight
import demos.tds.tictactoe.common.ui.theme.outlineVariantDark
import demos.tds.tictactoe.common.ui.theme.outlineVariantLight
import demos.tds.tictactoe.common.ui.theme.primaryContainerDark
import demos.tds.tictactoe.common.ui.theme.primaryContainerLight
import demos.tds.tictactoe.common.ui.theme.primaryDark
import demos.tds.tictactoe.common.ui.theme.primaryLight
import demos.tds.tictactoe.common.ui.theme.scrimDark
import demos.tds.tictactoe.common.ui.theme.scrimLight
import demos.tds.tictactoe.common.ui.theme.secondaryContainerDark
import demos.tds.tictactoe.common.ui.theme.secondaryContainerLight
import demos.tds.tictactoe.common.ui.theme.secondaryDark
import demos.tds.tictactoe.common.ui.theme.secondaryLight
import demos.tds.tictactoe.common.ui.theme.surfaceBrightDark
import demos.tds.tictactoe.common.ui.theme.surfaceBrightLight
import demos.tds.tictactoe.common.ui.theme.surfaceContainerDark
import demos.tds.tictactoe.common.ui.theme.surfaceContainerHighDark
import demos.tds.tictactoe.common.ui.theme.surfaceContainerHighLight
import demos.tds.tictactoe.common.ui.theme.surfaceContainerHighestDark
import demos.tds.tictactoe.common.ui.theme.surfaceContainerHighestLight
import demos.tds.tictactoe.common.ui.theme.surfaceContainerLight
import demos.tds.tictactoe.common.ui.theme.surfaceContainerLowDark
import demos.tds.tictactoe.common.ui.theme.surfaceContainerLowLight
import demos.tds.tictactoe.common.ui.theme.surfaceContainerLowestDark
import demos.tds.tictactoe.common.ui.theme.surfaceContainerLowestLight
import demos.tds.tictactoe.common.ui.theme.surfaceDark
import demos.tds.tictactoe.common.ui.theme.surfaceDimDark
import demos.tds.tictactoe.common.ui.theme.surfaceDimLight
import demos.tds.tictactoe.common.ui.theme.surfaceLight
import demos.tds.tictactoe.common.ui.theme.surfaceVariantDark
import demos.tds.tictactoe.common.ui.theme.surfaceVariantLight
import demos.tds.tictactoe.common.ui.theme.tertiaryContainerDark
import demos.tds.tictactoe.common.ui.theme.tertiaryContainerLight
import demos.tds.tictactoe.common.ui.theme.tertiaryDark
import demos.tds.tictactoe.common.ui.theme.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Composable
fun TicTacToeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) { darkScheme } else { lightScheme }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography(),
        content = content
    )
}


package prodigi.pdm.challenges.tictactoe

import android.content.Context
import android.os.LocaleList
import androidx.test.core.app.ApplicationProvider
import java.util.Locale

/**
 * Gets a Context with English locale (the application's default locale) for testing purposes.
 * This helps ensure that string resources are loaded in English during tests, regardless of the
 * device's locale settings.
 * @return A Context configured to use the English locale.
 */
fun getEnglishContext(): Context {
    val context = ApplicationProvider.getApplicationContext<Context>()
    context.resources.configuration.setLocales(LocaleList(Locale.ENGLISH))
    return context.createConfigurationContext(context.resources.configuration)
}
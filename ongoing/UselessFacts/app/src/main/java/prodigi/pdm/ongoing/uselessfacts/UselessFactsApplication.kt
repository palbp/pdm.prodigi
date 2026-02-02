package prodigi.pdm.ongoing.uselessfacts

import android.app.Application
import android.util.Log
import prodigi.pdm.ongoing.uselessfacts.services.RealUselessFactService

const val APP_TAG = "UselessFactsApp"

class UselessFactsApplication : Application() {

    /**
     * The actual service implementation that will be used by the rest of the app.
     */
    val service: UselessFactService by lazy {
        Log.v(APP_TAG, "Inside lazy block for property service")
        // FakeUselessFactService()
        // DataStoreUselessFactService(this)
        RealUselessFactService()
    }
}

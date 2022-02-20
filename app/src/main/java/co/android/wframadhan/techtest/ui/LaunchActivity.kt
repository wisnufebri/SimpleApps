package co.android.wframadhan.techtest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.android.wframadhan.techtest.ui.home.MainActivity
import co.android.wframadhan.techtest.utils.Coroutines
import co.android.wframadhan.techtest.utils.PreferenceProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

const val INTRO = "intro"
const val LOGIN = "login"

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    @Inject
    lateinit var prefs: PreferenceProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Coroutines.io {
            delay(2000L)
            val tClass = if (!prefs.getBoolean(INTRO)) {
                MainActivity::class.java
            } else if (prefs.getBoolean(LOGIN)) {
                MainActivity::class.java
            } else {
                MainActivity::class.java
            }
            startActivity(Intent(this, tClass))
            finish()
        }
    }

}
package app.android.dialliguapp.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import app.android.dialliguapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // to make tha layout fullscreen
        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )

        // Intent -> pass data between app components.// Intents are a powerful tool for communication and data sharing between app components in Android
        Handler().postDelayed(
            {
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            },
            2500
        )
    }
}
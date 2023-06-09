package app.android.dialliguapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import app.android.dialliguapp.R


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )

        val startGameButton = findViewById<Button>(R.id.btn_start_game)
        startGameButton.setOnClickListener {
            startActivity(Intent(this,InstructionsActivity::class.java))
        }

    }
}
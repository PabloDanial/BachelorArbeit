package app.android.dialliguapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import app.android.dialliguapp.R

class InstructionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
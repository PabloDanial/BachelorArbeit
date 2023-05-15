package app.android.dialliguapp.ui
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import app.android.dialliguapp.R

class GameNavigator : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_navigator)

        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )

        val adminButton = findViewById<Button>(R.id.adminButton)
        adminButton.setOnClickListener {
            startActivity(Intent(this, AdminActivity::class.java))
        }

        val playGameButton = findViewById<Button>(R.id.gameButton)
        playGameButton.setOnClickListener {
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }


}
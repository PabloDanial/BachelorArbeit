package app.android.dialliguapp.ui
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            //startActivity(Intent(this, AdminRegisteringPopUp::class.java))
            showAdminRegisteringPopUp()
        }

        val playGameButton = findViewById<Button>(R.id.gameButton)
        playGameButton.setOnClickListener {
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }

    fun showAdminRegisteringPopUp(){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.admin_registering_popup, null)
        dialogBuilder.setView(dialogView)

        val editTextUsername = dialogView.findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = dialogView.findViewById<EditText>(R.id.editTextPassword)
        val buttonSubmit = dialogView.findViewById<Button>(R.id.buttonSubmit)

        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        buttonSubmit.setOnClickListener {
            val userName = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            Toast.makeText(this, "I'm gonna change something ... Be patient ...", Toast.LENGTH_SHORT).show()
            /*val isCredentialValid = checkCredentials(userName, password)

            if (isCredentialValid){
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
                alertDialog.dismiss()
            }else{
                Toast.makeText(this, "Invalid username or password, please try again", Toast.LENGTH_SHORT).show()
            }*/
        }
    }

    /*
    fun checkCredentials(userName: String, password: String): Boolean{
        // Replace this with your actual authentication logic

        // Check if the username and password meet your validation criteria
        val validUserName = "admin"
        val validPassword = "password"

        return userName == validUserName && password == validPassword
    }*/


}
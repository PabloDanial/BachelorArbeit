package app.android.dialliguapp.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import app.android.dialliguapp.R
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_layout)

        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN,
        )

        val fileChooserButton = findViewById<Button>(R.id.btn_file_chooser)
        fileChooserButton.setOnClickListener {
            openFileChooser()// Call the openFileChooser() method when the button is clicked
        }

    }

    private val PICK_FILE_REQUEST_CODE = 1

    //to open file chooser
    fun openFileChooser(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*" // Specify MIME type or file types (e.g., "image/*")
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE)//startActivityForResult(intent, requestCode), the requestCode is a unique identifier for identifying the result of this specific intent later in the onActivityResult() method.
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                // Handle the selected image URI
                saveImageLocally(uri)
            }
        }
    }


    private fun saveImageLocally(imageUri: Uri) {
        val imageInputStream = contentResolver.openInputStream(imageUri)
        val outputDir = File(filesDir, "images")
        outputDir.mkdirs()
        val outputFile = File(outputDir, "my_app_image.jpg")
        val outputStream = FileOutputStream(outputFile)
        imageInputStream?.copyTo(outputStream)
        imageInputStream?.close()
        outputStream.close()
    }












}
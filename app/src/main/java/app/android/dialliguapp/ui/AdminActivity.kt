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

        val cameraButton = findViewById<Button>(R.id.btn_camera)
        cameraButton.setOnClickListener {
            openCamera()// Call the openCamera() method when the button is clicked
        }
    }

    private val PICK_FILE_REQUEST_CODE = 1
    private val CAMERA_REQUEST_CODE = 1
    private var selectedFileUri : Uri? = null

    //to open file chooser
    fun openFileChooser(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*" // Specify MIME type or file types (e.g., "image/*")
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE)//startActivityForResult(intent, requestCode), the requestCode is a unique identifier for identifying the result of this specific intent later in the onActivityResult() method.
    }


    fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file = createImageFile()
        val fileUri = FileProvider.getUriForFile(this, "your.file.provider.authority", file) //check documentation, what file provider ist ?!!
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    // Create a file to store the captured image
    fun createImageFile() : File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        val storageDir =getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imgFile = File.createTempFile("IMG_$timeStamp", ".jpg", storageDir)
        return imgFile
    }

    //Handle the Activity result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            when(resultCode){
                PICK_FILE_REQUEST_CODE -> {
                    //Handle file chooser result
                    selectedFileUri = data?.data
                    // Use the  selected file URI as needed
                }
                CAMERA_REQUEST_CODE -> {

                    // Handle camera capture result
                    // Use the captured image file URI (fileUri) as needed
                }
            }
        }
    }






}
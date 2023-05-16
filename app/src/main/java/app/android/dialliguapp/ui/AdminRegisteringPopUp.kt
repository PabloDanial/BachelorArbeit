package app.android.dialliguapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import app.android.dialliguapp.R

class AdminRegisteringPopUp:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_registering_popup)

        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN,
        )
    }

}
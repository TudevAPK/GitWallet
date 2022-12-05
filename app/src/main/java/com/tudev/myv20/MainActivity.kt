package com.tudev.myv20

import android.Manifest.permission.USE_FINGERPRINT
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat.from
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnLogin.setOnClickListener{
            var ac = etAc.text.toString()
            var pas = etPass.text.toString()
//
            if (ac.equals("tu") && pas.equals("123")){
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)}
            else Toast.makeText(this,"Sai!", Toast.LENGTH_SHORT).show()
        }
//        val bioCheck = BIOMETRIC_SERVICE
//        bioCheck.b
finger1.setOnClickListener{
    if (true){

        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)}

}

    } fun isBiometricPromptEnabled(): Boolean {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
    }

    fun isSdkVersionSupported(): Boolean {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    }
    fun isHardwareSupported(context: Context): Boolean {
       val fingerprintManager = from(context);
        return fingerprintManager.isHardwareDetected()
    }
    fun isFingerprintAvailable(context: Context?): Boolean {
        val fingerprintManager = from(context!!)
        return fingerprintManager.hasEnrolledFingerprints()
    }
}
package com.tudev.myv20

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val saveMoney= getSharedPreferences("Main", Context.MODE_PRIVATE)
        val resultLs:String = saveMoney.getString("lichSu1","").toString()
        tvRsLs.text = resultLs

    }
}
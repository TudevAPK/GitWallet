package com.tudev.myv20

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val money:String="TuDev"
        val lsMoney:String="lichSu1"
        val saveMoney = getSharedPreferences("Main", Context.MODE_PRIVATE)
        val editor = saveMoney.edit()
        tvTien.setOnClickListener {
            val intentLs = Intent(this,MainActivity3::class.java)
            startActivity(intentLs)
        }
        val str1 = StringBuilder("${saveMoney.getInt(money,0)}")
        tvTien.text = soTraVe(str1)
        btnTieu.setOnClickListener{
            val tienHienCo:Int = saveMoney.getInt(money,0)
            val dialogChi = Dialog(this)
            dialogChi.setContentView(R.layout.chi_dialog)

            val btnChi = dialogChi.findViewById<Button>(R.id.btnXnChi)
            val btnHuyChi = dialogChi.findViewById<Button>(R.id.btnHuyChi)
            val etSoTienChi = dialogChi.findViewById<EditText>(R.id.etChi)
            val etlsChi = dialogChi.findViewById<EditText>(R.id.etlsChi)


            //CHi TÊU
            btnChi.setOnClickListener {

                if (etSoTienChi.text.toString().equals("")){
                    Toast.makeText(this,"Nhập khoản chi!", Toast.LENGTH_SHORT).show()
                }else{
                    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                    val currentDate = sdf.format(Date())
                    val sChi = etSoTienChi.text.toString().toInt()
                    editor.putInt(money,tienHienCo-sChi)
                    val temp:String=" ${saveMoney.getString(lsMoney,"")}" +
                            " chi_${etlsChi.text}: $sChi  ($currentDate)\n-"
                    editor.putString(lsMoney,temp)
                    editor.apply()
                    dialogChi.dismiss()
                    val str2 = StringBuilder("${saveMoney.getInt(money,0)}")
                    Toast.makeText(this,"Đã chi $sChi Vnd", Toast.LENGTH_SHORT).show()
                    tvTien.text = soTraVe(str2)

                }}
            btnHuyChi.setOnClickListener {
                dialogChi.cancel()
            }

            dialogChi.show()
        }


//THU NHẬP
        btnThu.setOnClickListener{
            val tienHienCo:Int = saveMoney.getInt(money,0)
            val dialogThu = Dialog(this)
            dialogThu.setContentView(R.layout.thu_dialog)

            val btnXnThu = dialogThu.findViewById<Button>(R.id.btnXnThu)
            val btnHuyThu = dialogThu.findViewById<Button>(R.id.btnHuyThu)
            val etSoTienThu = dialogThu.findViewById<EditText>(R.id.etThu)
            val etlsThu = dialogThu.findViewById<EditText>(R.id.etlsThu)
            btnXnThu.setOnClickListener {
                if (etSoTienThu.text.toString().equals("")||etlsThu.text.toString().equals("")){
                    Toast.makeText(this,"Nhập khoản thu!", Toast.LENGTH_SHORT).show()
                }else {
                    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                    val currentDate = sdf.format(Date())
                    val sThu = etSoTienThu?.text.toString().toInt()
                    editor.putInt(money, tienHienCo + sThu)
                    val temp:String=" ${saveMoney.getString(lsMoney,"")}" +
                            " thu_${etlsThu.text}: $sThu ($currentDate)\n-"
                    editor.putString(lsMoney,temp)
                    editor.apply()
                    dialogThu.dismiss()
                    Toast.makeText(this, "Đã thu $sThu Vnd", Toast.LENGTH_SHORT).show()

                    val str3 = StringBuilder("${saveMoney.getInt(money,0)}")
                    tvTien.text = soTraVe(str3)
                }
            }
            btnHuyThu.setOnClickListener {
                dialogThu.cancel()
            }
            dialogThu.show()


        }

    }
    fun soTraVe(str:java.lang.StringBuilder):String{
        when(str.length){
            in 1..3->str.toString()
            in 4..6->str.insert(str.length-3,",")
            in 7..9->{str.insert(str.length-3,",")
                str.insert(str.length-7,",")}
            in 10..12->{str.insert(str.length-3,",")
                str.insert(str.length-7,",")
                str.insert(str.length-11,",")}
        }
        return "$str Vnd"
    }


}
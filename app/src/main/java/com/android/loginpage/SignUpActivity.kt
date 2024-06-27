package com.android.loginpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_success = findViewById<Button>(R.id.btn_success)
        val name = findViewById<EditText>(R.id.et_name)
        val id = findViewById<EditText>(R.id.et_id1)
        val password = findViewById<EditText>(R.id.et_ps1)

        btn_success.setOnClickListener{
            val strId = id.text.toString()
            val strPassword = password.text.toString()
            if(name.text.isNotBlank()&&id.text.isNotBlank()&&password.text.isNotBlank()){
                intent.putExtra("id",strId)
                intent.putExtra("password",strPassword)
                setResult(RESULT_OK,intent)
                finish()
            }
            else
                Toast.makeText(applicationContext,"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}
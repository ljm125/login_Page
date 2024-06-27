package com.android.loginpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_member = findViewById<Button>(R.id.btn_member)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_password = findViewById<EditText>(R.id.et_ps)


        btn_login.setOnClickListener{
            val strData = et_id.text.toString()
            if(et_id.text.isNotBlank()&&et_password.text.isNotBlank()) {
                Toast.makeText(applicationContext,"로그인 성공",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("DataFromSignInActivity",strData)
                startActivity(intent)
            }
            else
                Toast.makeText(applicationContext,"아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
        }

        btn_member.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val id = result.data?.getStringExtra("id")?:""
                    val password = result.data?.getStringExtra("password")?:""
                    et_id.setText(id)
                    et_password.setText(password)
                }
            }
    }
}
package com.android.loginpage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.Iv)
        when (Random.nextInt(5)) {
            // (0..4)까지의 인덱스
            0 -> imageView.setImageResource(R.drawable.image1)
            1-> imageView.setImageResource(R.drawable.image2)
            2 -> imageView.setImageResource(R.drawable.image3)
            3 -> imageView.setImageResource(R.drawable.image4)
            4 -> imageView.setImageResource(R.drawable.image5)

        }


        val strData = intent.getStringExtra("DataFromSignInActivity")
        val Text = findViewById<TextView>(R.id.tv_num1)
        Text.setText(strData)

        val btn_finish = findViewById<Button>(R.id.btn_end)
        btn_finish.setOnClickListener {
            finish()
        }
    }
}
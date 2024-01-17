package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.example.quizzify.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(3000){
            if(Firebase.auth.currentUser!= null){
                val intent= Intent(this,QuizPage::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent=Intent(this,SignUpPage::class.java)
                startActivity(intent)
            }
        }


    }
}
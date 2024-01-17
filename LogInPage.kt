package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzify.databinding.ActivityLogInPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LogInPage : AppCompatActivity() {
    private lateinit var binding:ActivityLogInPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpBtn.setOnClickListener {
            val intent=Intent(this,SignUpPage::class.java)
            startActivity(intent)
        }

        binding.logInBtn.setOnClickListener {
            if(Firebase.auth.currentUser !=null){
                val intent=Intent(this,QuizPage::class.java)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,"Wrong password",Toast.LENGTH_LONG).show()
            }
        }
    }
}
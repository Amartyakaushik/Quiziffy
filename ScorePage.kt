package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizzify.databinding.ActivityScorePageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ScorePage : AppCompatActivity() {
    private lateinit var binding:ActivityScorePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScorePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth=FirebaseAuth.getInstance()

        binding.Score.setText("Congrats!! Your score is ${intent.getIntExtra("SCORE",0)}")

//        To Sign out from the application
        binding.signOutBtn.setOnClickListener {
            logOut()
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent=Intent(this,LogInPage::class.java)
        startActivity(intent)

    }

    private fun logOut() {
        FirebaseAuth.getInstance().signOut()
    }

}
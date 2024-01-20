package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.quizzify.databinding.ActivityLogInPageBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LogInPage : AppCompatActivity() {
    private lateinit var binding:ActivityLogInPageBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            val intent=Intent(this,SignUpPage::class.java)
            startActivity(intent)
        }


        binding.logInBtn.setOnClickListener {task->
            val currentUser=auth.currentUser
            if(currentUser !=null){
                val intent=Intent(this,QuizPage::class.java)
                startActivity(intent)
                finish()

            }else {
                // Attempt to login
                val email = binding.email.text.toString()
                val password = binding.password.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Login successful
                            Log.d("LoginActivity", "Login successful")
                        } else {
                            // Login failed, check for specific error
                            val exception = task.exception
                            if (exception != null) {
                                Log.e("LoginActivity", "Login failed: ${exception.message}")
                                Toast.makeText(this, "Login failed: ${exception.message}", Toast.LENGTH_LONG).show()
                            } else {
                                Log.e("LoginActivity", "Login failed with unknown error")
                                Toast.makeText(this, "Unknown error", Toast.LENGTH_LONG).show()
                            }
                        }
                    })
            }




        }
    }
}
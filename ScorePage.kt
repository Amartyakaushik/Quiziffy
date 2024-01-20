package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzify.databinding.ActivityScorePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.tasks.OnCompleteListener

class ScorePage : AppCompatActivity() {
    private lateinit var binding: ActivityScorePageBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScorePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.Score.text = "Congrats!! Your score is ${intent.getIntExtra("SCORE", 0)}"

        // To Sign out from the application
        binding.signOutBtn.setOnClickListener {
            logOut()
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LogInPage::class.java)
        startActivity(intent)
        finish()
    }

    private fun logOut() {
        auth.signOut()
        auth.currentUser?.reload()
//        try {
//            auth.signOut()
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Toast.makeText(this, "Sign-out successful", Toast.LENGTH_SHORT).show()
//                        auth.currentUser?.reload()
//                    } else {
//                        Toast.makeText(this, "Error signing out", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Toast.makeText(this, "Exception: ${e.message}", Toast.LENGTH_SHORT).show()
//        }


//        auth.signOut()
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Toast.makeText(this, "Sign-out successful", Toast.LENGTH_SHORT).show()
//                    auth.currentUser?.reload()
//                } else {
//                    Toast.makeText(this, "Error signing out", Toast.LENGTH_SHORT).show()
//                }
//            }

    }


}



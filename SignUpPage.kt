package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzify.databinding.ActivitySignUpPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        for checking the password
        val password=binding.passWord.text.toString()


//        Change color of the button when the user check the termsAndContdition checkbox.
        binding.myCheckBox.setOnCheckedChangeListener { _, isChecked ->
            val buttonColor= if(isChecked) R.color.buttonCheckedColor else R.color.buttonDefaultColor
            binding.registerBtn.setBackgroundColor(resources.getColor(buttonColor, theme))
        }

//      If user already have an account or they have completed the registration then they need to move to the login page
        binding.logInBtn.setOnClickListener {
            val intent=Intent(this,LogInPage::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {

            if (binding.myCheckBox.isChecked()) {
                // Checkbox is checked, proceed with form submission
                Firebase.auth.createUserWithEmailAndPassword(
                    binding.email.text.toString(),
                    binding.passWord.text.toString())
                    .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User registered", Toast.LENGTH_LONG).show()
                        val intent=Intent(this,LogInPage::class.java)
                        intent.putExtra("Password",password)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "user not created", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this,"Please agree to the terms and conditions first.",Toast.LENGTH_LONG).show()
            }


        }
    }
}
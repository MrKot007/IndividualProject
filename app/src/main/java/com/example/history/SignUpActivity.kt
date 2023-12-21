package com.example.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.history.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUp.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (email == "" || password == "" || binding.repeatPassword.text.toString() == "") {
                return@setOnClickListener
            }else {
                try {
                    FirebaseConnection.registerUser(this@SignUpActivity, email, password)
                } catch (e: Exception) {
                    Toast.makeText(this@SignUpActivity, e.message.toString(), Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

            }
        }
    }
}
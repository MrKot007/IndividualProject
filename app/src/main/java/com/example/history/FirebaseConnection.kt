package com.example.history

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

object FirebaseConnection {
    private val auth = FirebaseAuth.getInstance()

    suspend fun registerUser(context: Context, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }
}
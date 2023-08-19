package com.example.alertaperu

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth
    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
        loginFirebase(email, pass)
    }

    private fun loginFirebase(email: String, pass: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->
                userLoginServiceResponse.value = task.isSuccessful
            }
    }

    fun recuperar(email: String) {
        recuperarClave(email)
    }

    // Recuperar Contraseña en firebase
    private fun recuperarClave(email: String) {
        auth = FirebaseAuth.getInstance()
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(Activity()) { task ->

            }
    }

}
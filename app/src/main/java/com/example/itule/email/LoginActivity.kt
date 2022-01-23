package com.example.itule.email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.itule.MenuActivity
import com.example.itule.QuizActivity
import com.example.itule.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var login : Button
    private lateinit var signup : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_login)
        login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            loginf()
        }
        signup = findViewById<TextView>(R.id.signup)
        signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

    }
    private fun loginf() {
        val emailTxt = findViewById<EditText>(R.id.usernameInput)
        val passwordTxt = findViewById<EditText>(R.id.passwordInput)
        val email = emailTxt.text.toString()
        val password = passwordTxt.text.toString()
        if (email.isEmpty()) {
            emailTxt.error = "Please enter valid email!"
        }
        else
        {
            login(email, password)
        }
        if (password.isEmpty()) {
            passwordTxt.error = "Please enter valid password!"
        }
        else
        {
            login(email, password)
        }

    }
    private fun login(email: String, password: String) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Login Success! ", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login failed, please try again! ", Toast.LENGTH_LONG).show()
            }
        }

    }
}
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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase : DatabaseReference
    lateinit var database : FirebaseDatabase
    lateinit var registerb : Button
    lateinit var username : EditText
    lateinit var passwordTxt : EditText
    lateinit var nameTxt : EditText
    private lateinit var login_txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerb = findViewById(R.id.register)
        username = findViewById(R.id.usernameInput)
        passwordTxt = findViewById(R.id.passwordInput)
        nameTxt = findViewById(R.id.nameInput)

        login_txt = findViewById<TextView>(R.id.login_text)
        login_txt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        mDatabase = database.getReference("Names")


        registerb.setOnClickListener {
            val email = username.text.toString().trim()
            val password = passwordTxt.text.toString().trim()
            val name = nameTxt.text.toString().trim()
            if(email.isEmpty() )
            {
                username.error="Please enter valid email!"
                return@setOnClickListener
            }
            if(name.isEmpty() )
            {
                nameTxt.error="Please enter valid name!"
                return@setOnClickListener
            }
            if(password.isEmpty() )
            {
                passwordTxt.error="Please enter valid password!"
                return@setOnClickListener
            }
            register(email, password, name)
        }
    }

    private fun register(emai : String, pass : String, nam : String) {

        mAuth.createUserWithEmailAndPassword(emai, pass).addOnCompleteListener(this){ task ->
            if (task.isSuccessful) {
                val currentUser = mAuth.currentUser
                val dat = mDatabase.child(currentUser.uid)
                dat.child("Name").setValue(nam)
                dat.child("Email").setValue(emai)
                Toast.makeText(this, "Registration Success. ", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,MenuActivity::class.java))
                finish()

            } else {
                Toast.makeText(this, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
            }
        }

    }
    }
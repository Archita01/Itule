package com.example.itule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

@Suppress("DEPRECATION")
class ProfileActivity : AppCompatActivity() {

    private lateinit var hamburgerImageButton: ImageButton
    private lateinit var button_click: Animation
    private lateinit var about: TextView
    lateinit var auth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference
    lateinit var database : FirebaseDatabase
    private lateinit var logout: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        button_click = AnimationUtils.loadAnimation(this, R.anim.button_click)

        hamburgerImageButton = findViewById(R.id.hamburgerImageButton)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        mDatabase = database.reference.child("Names")
        loadProfile()
        about = findViewById(R.id.about)
        logout = findViewById(R.id.logout)

        hamburgerImageButton.setOnClickListener(View.OnClickListener {
            hamburgerImageButton.setAnimation(button_click)
            Handler().postDelayed({
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }, 200)
        })

        about = findViewById(R.id.about)
        about.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            finish()
        })

        logout = findViewById(R.id.logout)
        logout.setOnClickListener(View.OnClickListener {
            auth = FirebaseAuth.getInstance()
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
    private fun loadProfile()
    {
        val currentuser = auth.currentUser

        val userreference = mDatabase.child(currentuser?.uid!!)
        val dispTxt = findViewById<TextView>(R.id.name)
        val emailt = findViewById<TextView>(R.id.email)
        userreference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dispTxt.text = snapshot.child("Name").value.toString()
                emailt.text = snapshot.child("Email").value.toString()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
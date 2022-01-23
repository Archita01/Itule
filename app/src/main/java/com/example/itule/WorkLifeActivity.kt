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

class WorkLifeActivity : AppCompatActivity() {
    private lateinit var text : TextView
    private lateinit var score : TextView
    private lateinit var schedule : TextView
    private lateinit var hamburgerImageButton: ImageButton
    private lateinit var button_click: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_life)
        score = findViewById(R.id.balance)
        text = findViewById(R.id.message)
        schedule = findViewById(R.id.schedule)
        val response = intent.getStringExtra("Response")
        score.text = response
        button_click = AnimationUtils.loadAnimation(this, R.anim.button_click)

        hamburgerImageButton = findViewById(R.id.hamburgerImageButton)

        hamburgerImageButton.setOnClickListener(View.OnClickListener {
            hamburgerImageButton.setAnimation(button_click)
            Handler().postDelayed({
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }, 200)
        })

        if(response!!.toFloat() >700.0){
            text.text= "Yayyy ! You have a great work-life balance. Keep up the good spirit."
            schedule.visibility = View.INVISIBLE
        }
        else if(response!!.toFloat() >680.0 && response!!.toFloat() <=700.0 )
        {
            text.text= "Congrats ! You have a good work-life balance."
        }
        else if(response!!.toFloat() >550.0 && response!!.toFloat() <=680.0 )
        {
            text.text= "You got an average score. You need to pull up your socks!"
        }
        else{
            text.text= "Oh snap ! The score is poor you need to improve."
        }

        schedule.setOnClickListener {
            startActivity(Intent(this, ScheduleActivity::class.java))
            finish()
        }
    }
}
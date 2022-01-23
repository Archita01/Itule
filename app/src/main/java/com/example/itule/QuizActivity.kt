package com.example.itule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class QuizActivity : AppCompatActivity() {
    private lateinit var submit : Button
    private lateinit var a1 : EditText
    private lateinit var a2 : EditText
    private lateinit var a3 : EditText
    private lateinit var a4 : EditText
    private lateinit var a5 : EditText
    private lateinit var a6 : EditText
    private lateinit var a7 : EditText
    private lateinit var a8 : EditText
    private lateinit var a9 : EditText
    private lateinit var a10 : EditText
    private lateinit var a11 : EditText
    private lateinit var a12 : EditText
    private lateinit var a13 : EditText
    private lateinit var a14 : EditText
    private lateinit var a15 : EditText
    private lateinit var a16 : EditText
    private lateinit var a17 : EditText
    private lateinit var a18 : EditText
    private lateinit var a19 : EditText
    private lateinit var a20 : EditText
    private lateinit var age1 : RadioButton
    private lateinit var age2 : RadioButton
    private lateinit var age3 : RadioButton
    private lateinit var age4 : RadioButton
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var hamburgerImageButton: ImageButton
    private lateinit var button_click: Animation

    private lateinit var age : String
    private lateinit var sex : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        button_click = AnimationUtils.loadAnimation(this, R.anim.button_click)

        hamburgerImageButton = findViewById(R.id.hamburgerImageButton)

        a1 = findViewById(R.id.ans1)
        a2 = findViewById(R.id.ans2)
        a3 = findViewById(R.id.ans3)
        a4 = findViewById(R.id.ans4)
        a5 = findViewById(R.id.ans5)
        a6 = findViewById(R.id.ans6)
        a7 = findViewById(R.id.ans7)
        a8 = findViewById(R.id.ans8)
        a9 = findViewById(R.id.ans9)
        a10 = findViewById(R.id.ans10)
        a11 = findViewById(R.id.ans11)
        a12 = findViewById(R.id.ans12)
        a13 = findViewById(R.id.ans13)
        a14 = findViewById(R.id.ans14)
        a15 = findViewById(R.id.ans15)
        a16 = findViewById(R.id.ans16)
        a17 = findViewById(R.id.ans17)
        a18 = findViewById(R.id.ans18)
        a19 = findViewById(R.id.ans19)
        a20 = findViewById(R.id.ans20)

        age1 = findViewById(R.id.op1)
        age2 = findViewById(R.id.op2)
        age3 = findViewById(R.id.op3)
        age4 = findViewById(R.id.op4)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        hamburgerImageButton.setOnClickListener(View.OnClickListener {
            hamburgerImageButton.setAnimation(button_click)
            Handler().postDelayed({
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }, 200)
        })

        age1.setOnClickListener {
            age = age1.text.toString()
        }
        age2.setOnClickListener {
            age = age2.text.toString()
        }
        age3.setOnClickListener {
            age = age3.text.toString()
        }
        age4.setOnClickListener {
            age = age4.text.toString()
        }
        male.setOnClickListener {
            sex="0"
        }
        female.setOnClickListener {
            sex="1"
        }

        submit = findViewById(R.id.submit)
        submit.setOnClickListener {
//            val url = "https://itule-team-up.herokuapp.com/?FRUITS_VEGGIES=5&DAILY_STRESS=4&PLACES_VISITED=0&CORE_CIRCLE=2&SUPPORTING_OTHERS=10&SOCIAL_NETWORK=10&ACHIEVEMENT=5%20&DONATION=1&BMI_RANGE=2&TODO_COMPLETED=7&FLOW=4&DAILY_STEPS=1&LIVE_VISION=5&SLEEP_HOURS=8&LOST_VACATION=5&DAILY_SHOUTING=2&SUFFICIENT_INCOME=2&PERSONAL_AWARDS=1&TIME_FOR_PASSION=8&WEEKLY_MEDITATION=4&AGE=21%20to%2035&GENDER=1"
            val url1 = "https://itule-team-up.herokuapp.com/?FRUITS_VEGGIES="+a1.text+"&DAILY_STRESS="+a2.text+"&PLACES_VISITED="+a3.text+"&CORE_CIRCLE="+a4.text+"&SUPPORTING_OTHERS="+a5.text+"&SOCIAL_NETWORK="+a6.text+"&ACHIEVEMENT="+a7.text+"&DONATION="+a8.text+"&BMI_RANGE="+a9.text+"&TODO_COMPLETED="+a10.text+"&FLOW="+a11.text+"&DAILY_STEPS="+a12.text+"&LIVE_VISION="+a13.text+"&SLEEP_HOURS="+a14.text+"&LOST_VACATION="+a15.text+"&DAILY_SHOUTING="+a16.text+"&SUFFICIENT_INCOME="+a17.text+"&PERSONAL_AWARDS="+a18.text+"&TIME_FOR_PASSION="+a19.text+"&WEEKLY_MEDITATION="+a20.text+"&AGE="+age+"&GENDER="+sex
            val queue = Volley.newRequestQueue(this)
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url1, null,
                { response ->
                    Log.e("Response:", response.getString("prediction"))
                    val intent = Intent(this, WorkLifeActivity::class.java)
                    intent.putExtra("Response", response.getString("prediction"))
                    startActivity(intent)
                    finish()
                },
                { error ->
                    Log.e("Response:", "Error ")

                }
            )
            queue.add(jsonObjectRequest)

// Access the RequestQueue through your singleton class.

        }
    }
}
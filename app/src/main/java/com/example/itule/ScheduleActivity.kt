package com.example.itule

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView

class ScheduleActivity : AppCompatActivity() {

    private lateinit var hamburgerImageButton: ImageButton
    private lateinit var button_click: Animation
    private lateinit var check1 : CheckBox
    private lateinit var check2 : CheckBox
    private lateinit var check3 : CheckBox
    private lateinit var check4 : CheckBox
    private lateinit var check5 : CheckBox
    private lateinit var check6 : CheckBox
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var text4: TextView
    private lateinit var text5: TextView
    private lateinit var text6: TextView
    private lateinit var percent: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var c = 0
        setContentView(R.layout.activity_schedule)
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

        check1 = findViewById(R.id.check1)
        check2 = findViewById(R.id.check2)
        check3 = findViewById(R.id.check3)
        check4 = findViewById(R.id.check4)
        check5 = findViewById(R.id.check5)
        check6 = findViewById(R.id.check6)
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)
        text4 = findViewById(R.id.text4)
        text5 = findViewById(R.id.text5)
        text6 = findViewById(R.id.text6)
        percent = findViewById(R.id.percent)

        check1.setOnClickListener{
            if(check1.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text1.setPaintFlags(text1.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text1.setPaintFlags(text1.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        check2.setOnClickListener{
            if(check2.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text2.setPaintFlags(text2.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text2.setPaintFlags(text2.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        check3.setOnClickListener{
            if(check3.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text3.setPaintFlags(text3.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text3.setPaintFlags(text3.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        check4.setOnClickListener{
            if(check4.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text4.setPaintFlags(text4.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text4.setPaintFlags(text4.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        check5.setOnClickListener{
            if(check5.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text5.setPaintFlags(text5.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text5.setPaintFlags(text5.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        check6.setOnClickListener{
            if(check6.isChecked)
            {
                c++
                Log.e("Check","is checked")
                percent.text = ((100*c)/6).toString()+"%"
                text6.setPaintFlags(text6.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                c--
                percent.text = ((100*c)/6).toString()+"%"
                text6.setPaintFlags(text6.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }

        }
        percent.text = "0%"



    }
}
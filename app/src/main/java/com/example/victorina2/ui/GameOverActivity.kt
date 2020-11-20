package com.example.victorina2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.victorina2.R
import kotlinx.android.synthetic.main.activity_game_over.*
import kotlinx.android.synthetic.main.activity_main.*

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        val correctAnswers = intent.getIntExtra("score",0)
        val questions = intent.getIntExtra("question",1)

        tv_result.text = "Siz $questions ta savoldan $correctAnswers ta topdingiz!"

        btn_play_again.setOnClickListener{
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }
    }

}
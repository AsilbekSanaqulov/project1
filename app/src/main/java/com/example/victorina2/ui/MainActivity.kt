package com.example.victorina2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.victorina2.R
import com.example.victorina2.util.Lists
import com.example.victorina2.util.Lists.Companion.images
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

/** O'YIN BOSHIDADI HOLAT */
    var questionNumber = 1
    var correctAnswers =0

    val numberOfQuestions = 7

    val images: MutableList<Int> = Lists.images
    val options: MutableList<String> = Lists.options

    var correctAnswer=""


    var generatedQuestions: MutableList<Int> = ArrayList()
    var generatedOptions: MutableList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateQuestion()

        btn_submit.setOnClickListener{
            questionNumber++
            val id = radioGroup.checkedRadioButtonId

            when(id){
                R.id.rb_1 -> {
                  if (correctAnswer == rb_1.text.toString()){
                      showToast("Javob to'gri")
                      correctAnswers++
                  }else
                      showToast("Javob noto'g'ri")

              }
                R.id.rb_2 -> {
                    if (correctAnswer == rb_2.text.toString()){
                        showToast("Javob to'gri")
                        correctAnswers++
                    }else
                        showToast("Javob noto'g'ri")

                }
                R.id.rb_3 -> {
                    if (correctAnswer == rb_3.text.toString()){
                        showToast("Javob to'gri")
                        correctAnswers++
                    }else
                        showToast("Javob noto'g'ri")

                }
                R.id.rb_4 -> {
                    if (correctAnswer == rb_4.text.toString()){
                        showToast("Javob to'gri")
                        correctAnswers++
                    }else
                        showToast("Javob noto'g'ri")

                }

            }

            generateQuestion()

            if (questionNumber>numberOfQuestions){
                tv_question.text = (numberOfQuestions-1).toString()
                gameOver()
            }
        }

    }

    fun generateQuestion() {
        if (questionNumber!=numberOfQuestions+1){
            rb_1.isChecked= true
            rb_2.isChecked= false
            rb_3.isChecked= false
            rb_4.isChecked= false

            generatedOptions.clear()

            tv_question.text= questionNumber.toString()
            tv_score.text = correctAnswers.toString()


            var random = (images.indices).random()

            while (random in generatedQuestions){
                random = (images.indices).random()

            }
            generatedQuestions.add(random)
            imageView.setImageResource(images[random])

            correctAnswer = options[random]

            generatedOptions.add(random)

            val radioButtons : MutableList<Int> = mutableListOf<Int>(
                R.id.rb_1,
                R.id.rb_2,
                R.id.rb_3,
                R.id.rb_4
            )


            val randomLocation = (radioButtons.indices).random()
            val correctButton = findViewById<RadioButton>(radioButtons[randomLocation])
            correctButton.text = correctAnswer


            for (i in radioButtons.indices){
                if (i == randomLocation)
                    continue

                val radioButton = findViewById<RadioButton>(radioButtons[i])
                random = (options.indices).random()

                while (random in generatedOptions){
                    random = (options.indices).random()
                }
                generatedOptions.add(random)
                radioButton.text = options[random]

            }

        }
    }
    fun showToast(str: String){
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }
    fun gameOver(){
        val intent = Intent(applicationContext,GameOverActivity::class.java)
        intent.putExtra("question",questionNumber-1)
        intent.putExtra("score",correctAnswers)
        startActivity(intent)
        finish()
    }


}
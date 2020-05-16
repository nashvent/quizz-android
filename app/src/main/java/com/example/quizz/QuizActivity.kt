package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class QuizActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val mTrueButton = findViewById<Button>(R.id.true_button)
        val mFalseButton = findViewById<Button>(R.id.false_button)

        mTrueButton.setOnClickListener {
            Toast.makeText(this@QuizActivity, R.string.correct_toast, Toast.LENGTH_SHORT).show()
        }

        mFalseButton.setOnClickListener {
            Toast.makeText(this@QuizActivity, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
        }

    }
}

class Question(var mTextResId:Int,var mAnswerTrue:Boolean) {
    init {
        //Log.d(mTextResId +" "+ mAnswerTrue)
    }

    fun getTextResId():Int{
        Log.i("hola","Munoo");
        return 0
    }
}

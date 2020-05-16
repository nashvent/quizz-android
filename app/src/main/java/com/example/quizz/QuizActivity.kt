package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    private val mQuestionBank = listOf<Question> (
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true)
    );
    var mCurrentIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var mQuestionTextView: TextView = findViewById<TextView>(R.id.question_text_view);

        var question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        val mTrueButton: Button = findViewById<Button>(R.id.true_button)
        val mFalseButton: Button = findViewById<Button>(R.id.false_button)
        val mNextButton: Button = findViewById(R.id.next_button)
        mTrueButton.setOnClickListener {
           checkAnswer(true);
        }
        mFalseButton.setOnClickListener {
            //Toast.makeText(this@QuizActivity, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
            checkAnswer(false);
        }

        mNextButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size;
            question = mQuestionBank[mCurrentIndex].getTextResId();
            mQuestionTextView.setText(question);
        }
    }

    private fun checkAnswer(userPressedTrue:Boolean){
        var answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        var messageResId = 0;

        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

}

class Question(textResId:Int, answerTrue:Boolean) {
    var mTextResId = textResId;
    var mAnswerTrue = answerTrue;
    init {
        //Log.d(mTextResId +" "+ mAnswerTrue)
    }

    fun getTextResId():Int{
        return this.mTextResId;
    }

    fun setTextResId(textResId:Int){
        this.mTextResId = textResId;
    }

    fun isAnswerTrue():Boolean{
        return this.mAnswerTrue;
    }

    fun setAnswerTrue(answerTrue:Boolean){
        this.mAnswerTrue = answerTrue;
    }
}
    
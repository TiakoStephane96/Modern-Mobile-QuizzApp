package com.example.quizzapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private  var mCurrentPosition:Int = 1
    private  var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private  var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.User_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option01.setOnClickListener(this)
        tv_option02.setOnClickListener(this)
        tv_option03.setOnClickListener(this)
        tv_option04.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }
    private fun setQuestion(){

        val question: Questions? = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progessBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition"+ "/" + progessBar.max

        tv_question.text = question!!.question

        iv_image.setImageResource(question.image)

        tv_option01.text = question.optionOne
        tv_option02.text = question.optionTwo
        tv_option03.text = question.optionThree
        tv_option04.text = question.optionFour
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option01)
        options.add(1,tv_option02)
        options.add(2,tv_option03)
        options.add(3,tv_option04)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.tv_option01 ->{
                selectedOptionView(tv_option01,1)
            }
            R.id.tv_option02 ->{
                selectedOptionView(tv_option02,2)
            }
            R.id.tv_option03 ->{
                selectedOptionView(tv_option03,3)
            }
            R.id.tv_option04 ->{
                selectedOptionView(tv_option04,4)
            }
            R.id.btn_submit ->{

                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                           val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.User_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size)
                    {
                        btn_submit.text ="FINISH"
                    }
                    else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private  fun answerView(answer: Int, drawableView: Int)
    {
        when(answer){
            1 ->{
                tv_option01.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 ->{
                tv_option02.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 ->{
                tv_option03.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 ->{
                tv_option04.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

    private  fun selectedOptionView(tv: TextView,
                                    selectedOptionNum: Int)
    {

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}
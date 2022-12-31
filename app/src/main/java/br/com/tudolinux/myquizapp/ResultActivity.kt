package br.com.tudolinux.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private var mUserName : String? = null
    private var mTotalQuestions : Int? = null
    private var mTotalCorrectAnswer : Int? = null

    private var tvUserName : TextView? = null
    private var tvScore : TextView? = null
    private var btnFinish : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mTotalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        mTotalCorrectAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvUserName = findViewById(R.id.tv_name)
        tvScore = findViewById(R.id.tv_score)
        btnFinish = findViewById(R.id.btn_finish)

        tvUserName?.text = mUserName
        tvScore?.text = "Your Score is $mTotalCorrectAnswer out of $mTotalQuestions"

        btnFinish?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.example.kailunlew.quizapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;


    public int counter = 30 ;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);
        timer= (TextView) findViewById(R.id.timer);

        updateQuestion();

         final CountDownTimer yourCountDownTimer = new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                timer.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                counter=30;
                Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", mScore);
                i.putExtras(bundle);
                QuizActivity.this.finish();
                startActivity(i);
                cancel();
                finish();

            }
        }.start();

        //Logic for True Button
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(mAnswer == true){
                    mScore++;  //This updates the score int variable
                    updateScore(mScore);  //This converts the int variable to a String and adds it to the mScoreView

                    //Perform this check before you update the question
                    if(mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        yourCountDownTimer.cancel();
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        updateQuestion();
                    }
                }

                //If the user's answer is wrong
                else{
                    if(mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        yourCountDownTimer.cancel();
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        updateQuestion();
                    }
                }
            }
        });


        //Logic for False Button
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(mAnswer == false){
                    mScore++;  //This updates the score int variable
                    updateScore(mScore);  //This converts the int variable to a String and adds it to the mScoreView

                    //Perform this check before you update the question
                    if(mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        yourCountDownTimer.cancel();
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        updateQuestion();
                    }
                }

                //If the user's answer is wrong
                else{
                    if(mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        yourCountDownTimer.cancel();
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        updateQuestion();
                    }
                }
            }
        });


    }

    private void updateQuestion(){
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    public void updateScore(int point){
        mScoreView.setText("" + mScore);
    }

}

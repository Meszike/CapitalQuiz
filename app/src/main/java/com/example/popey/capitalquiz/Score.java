package com.example.popey.capitalquiz;


/**
 * Created by POPEY on 2018. 01. 04..
 */



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class Score extends AppCompatActivity {

    //global variables
    public int rightAnswers = 0;
    public int questionNumber = 0;
    private TextView scoreView;
    private TextView sumView;
    Button restartButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.score);
        Bundle extras = getIntent().getExtras();

        //display score
        scoreView = (TextView) findViewById(R.id.right);
        rightAnswers = extras.getInt("rightAnswers");
        scoreView.setText(String.valueOf(rightAnswers));
        sumView = (TextView) findViewById(R.id.sum);
        Radio_B qrb = new Radio_B();
        sumView.setText(String.valueOf(qrb.maxQuestionNumber));




        // restart button click
        restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }





}


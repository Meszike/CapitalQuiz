package com.example.popey.capitalquiz;


/**
 * Created by POPEY on 2018. 01. 04..
 */



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Result extends AppCompatActivity {

    //global variables
    private int rightAnswers = 0;
    private int questionNumber = 0;

    private TextView scoreView;
    private TextView sumView;
    Button endButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();

        scoreView = (TextView) findViewById(R.id.right);
        rightAnswers = extras.getInt("rightAnswers");
        scoreView.setText(String.valueOf(rightAnswers));

        sumView = (TextView) findViewById(R.id.sum);
        QuestionRadioButton qrb = new QuestionRadioButton();
        sumView.setText(String.valueOf(qrb.maxQuestionNumber));




        // Widgets
        endButton = (Button) findViewById(R.id.endButton);

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }





}

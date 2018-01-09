package com.example.popey.capitalquiz;

/**
 * Created by POPEY on 2018. 01. 04..
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Text extends AppCompatActivity {

    //variables
    public boolean checked = false;
    public int questionNumber = 0;
    public int rightAnswers = 0;

    //sources
    ImageView questionImage = null;
    TextView question = null;
    TextView solution = null;
    EditText answer = null;
    Button checkButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
         //extras
        Bundle extras = getIntent().getExtras();
        questionNumber = extras.getInt("questionNumber");
        rightAnswers = extras.getInt("rightAnswers");

        //imports
        questionImage = (ImageView) findViewById(R.id.questionImage);
        question = (TextView) findViewById(R.id.question);
        answer = (EditText) findViewById(R.id.txtAnswer);
        solution = (TextView) findViewById(R.id.solution);
        checkButton = (Button) findViewById(R.id.check_button);

        //which question switch
        switch (questionNumber) {
            case 1:
                questionImage.setImageResource(R.drawable.question1);
                question.setText(R.string.question_1);
                break;
            case 4:
                questionImage.setImageResource(R.drawable.question4);
                question.setText(R.string.question_4);
                break;
            case 7:
                questionImage.setImageResource(R.drawable.question7);
                question.setText(R.string.question_7);
                break;
            case 9:
                questionImage.setImageResource(R.drawable.question9);
                question.setText(R.string.question_9);
                break;
        }

        //checkButton click
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to next Question
                if (checked) {
                    Intent nextQuestion = new Intent(Text.this, Radio_B.class);
                    questionNumber++;
                    nextQuestion.putExtra("questionNumber", questionNumber);
                    nextQuestion.putExtra("rightAnswers", rightAnswers);
                    startActivity(nextQuestion);
                    finish();
                } else {
                    String correctAnswer = null;

                    //which Choice is correct
                    switch (questionNumber) {
                        case 1:
                            correctAnswer = getString(R.string.question_1_answer);
                            break;
                        case 4:
                            correctAnswer = getString(R.string.question_4_answer);
                            break;
                        case 7:
                            correctAnswer = getString(R.string.question_7_answer);
                            break;
                        case 9:
                            correctAnswer = getString(R.string.question_9_answer);
                            break;
                    }
                    // Answer is correct
                    if (answer.getText().toString().equalsIgnoreCase(correctAnswer)) {
                        solution.setText(getString(R.string.correct));
                        rightAnswers++;
                        // Answer is wrong
                    } else {
                        solution.setText(getString(R.string.wrong_solution) + " " + correctAnswer);
                    }
                    checkButton.setText(R.string.next);
                    checked = true;
                }
            }
        });


    }
}

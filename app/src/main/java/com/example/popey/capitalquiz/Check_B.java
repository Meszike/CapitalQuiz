package com.example.popey.capitalquiz;

/**
 * Created by POPEY on 2018. 01. 04..
 */

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class Check_B extends AppCompatActivity{

    //global variables
    public boolean checked = false;
    public int questionNumber = 0;
    public int rightAnswers = 0;

    //sources
    ImageView questionImage = null;
    TextView question = null;
    CheckBox choice1 = null;
    CheckBox choice2 = null;
    CheckBox choice3 = null;
    CheckBox choice4 = null;
    Button checkButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_b);
        Bundle extras = getIntent().getExtras();
        questionNumber = extras.getInt("questionNumber");
        rightAnswers = extras.getInt("rightAnswers");

        //imports
        questionImage = (ImageView) findViewById(R.id.questionImage);
        question = (TextView) findViewById(R.id.question);
        choice1 = (CheckBox) findViewById(R.id.choice_1);
        choice2 = (CheckBox) findViewById(R.id.choice_2);
        choice3 = (CheckBox) findViewById(R.id.choice_3);
        choice4 = (CheckBox) findViewById(R.id.choice_4);

        //which question switch
        switch (questionNumber) {
            case 3:
                question.setText(R.string.question_3);
                questionImage.setImageResource(R.drawable.question3);
                choice1.setText(getString(R.string.question_3_choice_1));
                choice2.setText(getString(R.string.question_3_choice_2));
                choice3.setText(getString(R.string.question_3_choice_3));
                choice4.setText(getString(R.string.question_3_choice_4));
                break;
            case 6:
                question.setText(R.string.question_6);
                questionImage.setImageResource(R.drawable.question6);
                choice1.setText(getString(R.string.question_6_choice_1));
                choice2.setText(getString(R.string.question_6_choice_2));
                choice3.setText(getString(R.string.question_6_choice_3));
                choice4.setText(getString(R.string.question_6_choice_4));
                break;
        }
          //checkButton click
        checkButton = (Button) findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to next Question
                if (checked) {
                    Intent nextQuestion = new Intent(Check_B.this, Text.class);
                    questionNumber++;
                    nextQuestion.putExtra("questionNumber", questionNumber);
                    nextQuestion.putExtra("rightAnswers", rightAnswers);
                    startActivity(nextQuestion);
                    finish();
                } else {
                    String correctChoices = null;
                    boolean answeredCorrectly = true;
                    //which Choice is correct
                    switch (questionNumber) {
                        case 3:
                            correctChoices = getString(R.string.question_3_correct_ones);
                            break;
                        case 6:
                            correctChoices = getString(R.string.question_6_correct_ones);
                            break;
                    }

                    //booleans
                    boolean answer1Correct = (correctChoices.indexOf("1") != -1);
                    boolean answer2Correct = (correctChoices.indexOf("2") != -1);
                    boolean answer3Correct = (correctChoices.indexOf("3") != -1);
                    boolean answer4Correct = (correctChoices.indexOf("4") != -1);

                    // Change correct answer green
                    if (answer1Correct)
                        choice1.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorGreen));
                    if (answer2Correct)
                        choice2.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorGreen));
                    if (answer3Correct)
                        choice3.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorGreen));
                    if (answer4Correct)
                        choice4.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorGreen));

                    // Check if correct answers were selected
                    if(answer1Correct && !choice1.isChecked()) answeredCorrectly = false;
                    if(answer2Correct && !choice2.isChecked()) answeredCorrectly = false;
                    if(answer3Correct && !choice3.isChecked()) answeredCorrectly = false;
                    if(answer4Correct && !choice4.isChecked()) answeredCorrectly = false;

                    // Change incorrect answer red
                    if (!answer1Correct && choice1.isChecked()) {
                        choice1.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorRed));
                        answeredCorrectly = false;
                    }
                    if (!answer2Correct && choice2.isChecked()) {
                        choice2.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorRed));
                        answeredCorrectly = false;
                    }
                    if (!answer3Correct && choice3.isChecked()) {
                        choice3.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorRed));
                        answeredCorrectly = false;
                    }
                    if (!answer4Correct && choice4.isChecked()) {
                        choice4.setTextColor(ContextCompat.getColor(Check_B.this, R.color.colorRed));
                        answeredCorrectly = false;
                    }

                    if (answeredCorrectly) {
                        rightAnswers++;
                    }
                    checkButton.setText(R.string.next);
                    checked = true;
                }
            }
        });
    }
}
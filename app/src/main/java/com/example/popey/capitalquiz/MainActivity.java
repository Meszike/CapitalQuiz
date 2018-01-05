package com.example.popey.capitalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

      //global variables
      private int questionNumber = 1;

      //sources
    Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // StartButton click
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent question1 = new Intent(MainActivity.this,QuestionTextfield.class);
                question1.putExtra("questionNumber",1);
                startActivity(question1);
            }
        });


    }
}

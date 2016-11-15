package com.alfredo.androidterminologyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    CheckBox answer;

    Questions q = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
    }

    public void nextQuestion(View view){
        questionTextView.setText(q.getEasyQuestion());
    }

}




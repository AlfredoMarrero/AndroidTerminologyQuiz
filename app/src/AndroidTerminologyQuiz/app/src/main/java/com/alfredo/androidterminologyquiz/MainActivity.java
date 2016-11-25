package com.alfredo.androidterminologyquiz;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    CheckBox multipleChoice, shortAnswer;
    LinearLayout checkBoxLayout;
    QuestionSet q = new QuestionSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        checkBoxLayout = (LinearLayout) findViewById(R.id.checkboxes_linearLayout_view);

        multipleChoice = (CheckBox) findViewById(R.id.multiple_choice);
        shortAnswer = (CheckBox) findViewById(R.id.short_answer);

        multipleChoice.setChecked(true);
        setCheckBoxQuestions();
    }
    //Display short answer questions
    public void displayShortAnswer(View view){

        if(shortAnswer.isChecked()){
            multipleChoice.setChecked(false);
            setShortAnswerQuestion();
        }
    }
    //Displays multiple choice questions
    public void displayMultipleChoice(View view){
        if(multipleChoice.isChecked()){
            shortAnswer.setChecked(false);
            setCheckBoxQuestions();
        }
    }

    public void nextQuestion(View view){
        setCheckBoxQuestions();
    }

    public void setCheckBoxQuestions(){
        questionTextView.setText(q.getEasyQuestion());

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        q.setQuestions();

        checkBoxLayout.removeAllViewsInLayout();

        for (int i = 0; i < q.maxNumCheckbox(); i++){

            CheckBox checkBox = new CheckBox(this);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setText(q.getCheckboxText());
            //checkBox.setId(Integer.parseInt(q.getCheckboxText()));
            checkBoxLayout.addView(checkBox);
            q.nextCheckboxIndex();
        }

        q.nextIndex();
    }

    public void setShortAnswerQuestion(){

    }
}




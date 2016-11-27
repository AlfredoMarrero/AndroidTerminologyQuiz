package com.alfredo.androidterminologyquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView score;
    TextView questionTextView;
    CheckBox multipleChoice, shortAnswer;
    LinearLayout checkBoxLayout;
    QuestionSet q = new QuestionSet();
    //List <Integer> checkboxesSelected;
    List<Integer> checkboxesSelected = new ArrayList<>();
    double userScore = 0;

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

        score = (TextView) findViewById(R.id.user_score);
        score.setText(userScore + "/" + q.getTotalNumberOfQuestions() + ".0");
    }

    //Display short answer questions
    public void displayShortAnswer(View view){

        if(shortAnswer.isChecked()){
            multipleChoice.setChecked(false);
            //setShortAnswerQuestion();
            q.setShortAnswerQuestions();
            //setCheckBoxQuestions();
            setShortAnswerQuestions();
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
        int numberOfCheckboxesChecked = 0;

      //  for (int i = 0; i < q.maxNumCheckbox(); i++){
            //CheckBox findIfChecked = (CheckBox) findViewById(R.id.(i));
            //ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.)).getChildAt(0);
        //}
        int checkboxSelected;

        for(int index=0; index< checkBoxLayout.getChildCount(); ++index) {
            CheckBox nextChild = (CheckBox) checkBoxLayout.getChildAt(index);

            if(nextChild.isChecked()){
                checkboxesSelected.add(nextChild.getId());
                //checkboxSelected = nextChild.getId();
                numberOfCheckboxesChecked++;
            }
        }

        if(numberOfCheckboxesChecked == 1 && !checkboxesSelected.isEmpty() && checkboxesSelected.get(0) == q.getAnswer()) {

            setCheckBoxQuestions();
            userScore++;
            Context context = getApplicationContext();
            CharSequence text = "You answer is correct!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{

            userScore -= 0.5;
        }
        score.setText(userScore + "/" + q.getTotalNumberOfQuestions() + ".0");
        checkboxesSelected.clear();
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
            checkBox.setId(i);
            checkBoxLayout.addView(checkBox);
            q.nextCheckboxIndex();
        }
        q.nextIndex();
    }

    public void setShortAnswerQuestions(){

        questionTextView.setText(q.getEasyQuestion());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 15, 0, 0);
        q.setQuestions();
        checkBoxLayout.removeAllViewsInLayout();

            EditText shortAnswer = new EditText(this);
            //CheckBox checkBox = new CheckBox(this);
            shortAnswer.setLayoutParams(layoutParams);
//          shortAnswer.setText(q.getCheckboxText());
            shortAnswer.setId(0);
            checkBoxLayout.addView(shortAnswer);
            q.nextCheckboxIndex();
            q.nextIndex();

    }


}




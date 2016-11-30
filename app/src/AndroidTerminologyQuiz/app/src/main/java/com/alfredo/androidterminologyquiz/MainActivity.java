package com.alfredo.androidterminologyquiz;

import android.content.Context;
import android.graphics.Typeface;
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
    ShortAnswerQuestion shortAnswerQuestion = new ShortAnswerQuestion();

    List<Integer> checkboxesSelected = new ArrayList<>();
    double userScore = 0;
    EditText shortAnswerInput;

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
        score.setText(userScore + "/" + q.getArrayIndex() + ".0");
    }

    //////////////////////////////////
    //Checkboxes to change set of answers
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Display short answer questions
    public void displayShortAnswer(View view){

        if(shortAnswer.isChecked()){
            userScore = 0;
            multipleChoice.setChecked(false);
            shortAnswerQuestion.setArrayIndex();
            shortAnswerQuestion.setShortAnswerQuestions();
            setViewWithShortAnswerQuestion();
            updateScore();
        }
    }
    //Displays multiple choice questions
    public void displayMultipleChoice(View view){
        if(multipleChoice.isChecked()){
            userScore = 0;
            q.setArraysIndex();
            shortAnswer.setChecked(false);
            q.setMultipleChoiceQuestions();
            setCheckBoxQuestions();
            updateScore();
        }
    }

    //////////////////////////////
    //Next question button. Checks if user answer is correct; if it is correct then sets next question
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void gotoNextQuestionIfAnswerCorrect(View view){

        if(multipleChoice.isChecked()){
            int numberOfCheckboxesChecked = 0;
            for(int index = 0; index < checkBoxLayout.getChildCount(); ++index) {

                CheckBox nextChild = (CheckBox) checkBoxLayout.getChildAt(index);
                if(nextChild.isChecked()){
                    checkboxesSelected.add(nextChild.getId());
                    numberOfCheckboxesChecked++;
                }
            }

            if(numberOfCheckboxesChecked == 1 && !checkboxesSelected.isEmpty() && checkboxesSelected.get(0) == q.getAnswer()) {

                userScore++;
                Context context = getApplicationContext();
                CharSequence text = "You answer is correct!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                q.nextIndex();
                setCheckBoxQuestions();
            }
            else if (Math.abs(userScore) < q.getTotalNumberOfQuestions() && userScore > 0){
                userScore -= 0.5;
            }
            checkboxesSelected.clear();
        }
        else if (shortAnswer.isChecked()) {

            String userAnswer = shortAnswerInput.getText().toString();

            if(userAnswer != null && !shortAnswerQuestion.isDoneWithQuestions() && userAnswer.equalsIgnoreCase(shortAnswerQuestion.getShortAnswer())) {
                shortAnswerQuestion.nextIndex();
                setViewWithShortAnswerQuestion();
                userScore++;
            }
            else if(shortAnswerQuestion.getArrayIndex() + 1 <= q.getTotalNumberOfQuestions() && !shortAnswerQuestion.isDoneWithQuestions() && userScore > 0){
                userScore -= 0.5;
            }
        }
        updateScore();
    }

    public void updateScore(){

        if(shortAnswer.isChecked()){
            score.setText(userScore + "/" + shortAnswerQuestion.getArrayIndex() + ".0");
        }
        else{
            score.setText(userScore + "/" + q.getArrayIndex() + ".0");
        }
    }

    //////////////////////////////////////
    //Set-Fetch next question
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void setCheckBoxQuestions(){

        String questionHeader = q.getQuestionHeader();

        questionTextView.setText(questionHeader != null? questionHeader: "Congrats you have finished all the questions.");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 10, 0, 0);

        checkBoxLayout.removeAllViewsInLayout();

        if(questionHeader != null){
            for (int i = 0; i < q.maxNumCheckbox(); i++){
                CheckBox checkBox = new CheckBox(this);
                checkBox.setLayoutParams(layoutParams);
                checkBox.setText(q.getCheckboxText());
                checkBox.setTypeface(Typeface.SANS_SERIF);
                checkBox.setId(i);
                checkBoxLayout.addView(checkBox);
                q.nextCheckboxIndex();
            }
        }
    }

    public void setViewWithShortAnswerQuestion(){

        checkBoxLayout.removeAllViewsInLayout();
        String questionHeader = shortAnswerQuestion.getQuestionHeader();

        questionTextView.setText(questionHeader != null? questionHeader: "Congrats you have finished all the questions.");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 15, 0, 0);

        if(questionHeader != null) {
            shortAnswerInput = new EditText(this);
            shortAnswerInput.setLayoutParams(layoutParams);
            shortAnswerInput.setId(0);
            shortAnswerInput.setHint("Type answer");
            checkBoxLayout.addView(shortAnswerInput);
        }
    }
}




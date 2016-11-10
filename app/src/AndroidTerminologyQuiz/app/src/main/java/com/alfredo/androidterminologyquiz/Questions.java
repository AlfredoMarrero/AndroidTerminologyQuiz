package com.alfredo.androidterminologyquiz;

/**
 * Created by alfred on 11/9/16.
 */

public class Questions
{
    private static final int MAX_QUESTIONS = 4;
    String[] questionsArray = new String[MAX_QUESTIONS];
    int arrayIndex = 0;

    Questions(){
        setEasyQuestions();
    }

    public void setEasyQuestions(){
        questionsArray[0] = "Question 1";
        questionsArray[1] = "Question 2";
        questionsArray[2] = "Question 3";
        questionsArray[3] = "Question 4";
    }

    public String getEasyQuestion (){

        if(arrayIndex < MAX_QUESTIONS){
            return questionsArray[arrayIndex++];
        }
        return questionsArray[MAX_QUESTIONS - 1];
    }

    public void getAnswers(){
        questionsArray[0] = "Question 1";
        questionsArray[1] = "Question 2";
        questionsArray[2] = "Question 3";
        questionsArray[3] = "Question 4";
    }





}

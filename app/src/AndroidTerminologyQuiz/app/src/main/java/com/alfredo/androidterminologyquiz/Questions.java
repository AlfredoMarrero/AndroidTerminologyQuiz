package com.alfredo.androidterminologyquiz;

/**
 * Created by alfred on 11/9/16.
 */


public class QuestionSet
{
    private static final int MAX_QUESTIONS = 4;
    QuestionObject[] questionsArray = new QuestionObject[MAX_QUESTIONS];
    int arrayIndex = 0;

    QuestionSet(){
        setEasyQuestions();
    }

    public void setEasyQuestions(){

        questionsArray[0].questionHeader = "Question 1";
        questionsArray[1].questionHeader = "Question 2";
        questionsArray[2].questionHeader = "Question 3";
        questionsArray[3].questionHeader = "Question 4";

        questionsArray[0].checkbox1 = "Question 1 answer";
        questionsArray[0].checkbox2 = "Q 1 Answer 2";
        questionsArray[0].checkbox3 = "Q 1 answer 3";
        questionsArray[0].checkbox4 = "Q 1 answer 4";
        questionsArray[0].answer = 2;

        questionsArray[1].checkbox1 = "Question 2 answer";
        questionsArray[1].checkbox2 = "Q 2 Answer 2";
        questionsArray[1].checkbox3 = "Q 2 answer 3";
        questionsArray[1].checkbox4 = "Q 2 answer 4";
        questionsArray[1].answer = 3;

        questionsArray[2].checkbox1 = "Question 3 answer";
        questionsArray[2].checkbox2 = "Q 3 Answer 2";
        questionsArray[2].checkbox3 = "Q 3 answer 3";
        questionsArray[2].checkbox4 = "Q 3 answer 4";
        questionsArray[2].answer = 3;

        questionsArray[3].checkbox1 = "Question 4 answer";
        questionsArray[3].checkbox2 = "Q 4 Answer 2";
        questionsArray[3].checkbox3 = "Q 4 answer 3";
        questionsArray[3].checkbox4 = "Q 4 answer 4";
        questionsArray[3].answer = 1;
    }

    public String getEasyQuestion (){

        if(arrayIndex < MAX_QUESTIONS){
            return questionsArray[arrayIndex++].questionHeader;
        }
        return questionsArray[MAX_QUESTIONS - 1].questionHeader;
    }

    private class QuestionObject{
        String questionHeader;
        String checkbox1;
        String checkbox2;
        String checkbox3;
        String checkbox4;
        int answer;
    }
}

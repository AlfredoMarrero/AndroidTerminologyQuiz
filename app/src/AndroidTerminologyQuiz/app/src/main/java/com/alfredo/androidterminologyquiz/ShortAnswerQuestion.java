package com.alfredo.androidterminologyquiz;
/**
 * Created by alfred on 11/28/16.
 */

public class ShortAnswerQuestion {

    private static final int MAX_QUESTIONS = 5;
    ShortAnswerQuestionObject[] shortAnswerQuestionsArray;
    int arrayIndex = 0;

    ShortAnswerQuestion(){
        setShortAnswerQuestions();
    }

    public void setShortAnswerQuestions(){

        shortAnswerQuestionsArray = new ShortAnswerQuestionObject[MAX_QUESTIONS];

        for(int i =  0; i < MAX_QUESTIONS; i++){
            shortAnswerQuestionsArray[i] = new ShortAnswerQuestionObject();
        }

        //Questions
        shortAnswerQuestionsArray[0].questionHeader = "What do ADT stands for?";
        shortAnswerQuestionsArray[1].questionHeader = "What do ADK stands for?";
        shortAnswerQuestionsArray[2].questionHeader = "What does DDMS stands for?";
        shortAnswerQuestionsArray[3].questionHeader = "What does AAPT stands for?";
        shortAnswerQuestionsArray[4].questionHeader = " What tools are placed in An Android SDK?";

        //Answers
        shortAnswerQuestionsArray[0].questionAnswer = "Android Development Tools";
        shortAnswerQuestionsArray[1].questionAnswer = "Android Development Kit";
        shortAnswerQuestionsArray[2].questionAnswer = "Dalvik Debug Monitoring Services";
        shortAnswerQuestionsArray[3].questionAnswer = "Android Asset Packaging tool";
        shortAnswerQuestionsArray[4].questionAnswer = "Android Emulator, DDMS, AAPT, ADB";
    }

    public void setArrayIndex(){
        arrayIndex = 0;
    }

    public void nextIndex(){
        if(arrayIndex < MAX_QUESTIONS) {
            arrayIndex++;
        }
    }

    public int getArrayIndex(){
        return arrayIndex;
    }

    public int getTotalNumberOfQuestions(){
        return MAX_QUESTIONS;
    }

    public String getShortAnswer(){
        return shortAnswerQuestionsArray[arrayIndex].questionAnswer;
    }

    public String getQuestionHeader (){

        if(arrayIndex < MAX_QUESTIONS){
            return shortAnswerQuestionsArray[arrayIndex].questionHeader;
        }
        return null;
    }

    public Boolean isDoneWithQuestions(){

        return !(arrayIndex < MAX_QUESTIONS);
    }

    class ShortAnswerQuestionObject{

        public String questionHeader;
        public String questionAnswer;
        public String explanation;
    }
}



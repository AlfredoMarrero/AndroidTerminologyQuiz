package com.alfredo.androidterminologyquiz;
/**
 * Created by alfred on 11/9/16.
 */

public class QuestionSet
{
    private static final int MAX_QUESTIONS = 10;

    QuestionObject[] questionsArray;

    int arrayIndex = 0;
    int checkBoxIndex = 0;

    QuestionSet(){
        setMultipleChoiceQuestions();
    }

    public void setMultipleChoiceQuestions(){

        questionsArray = new QuestionObject[MAX_QUESTIONS];

        for (int i = 0; i < MAX_QUESTIONS; i++){
            questionsArray[i] = new QuestionObject();
            questionsArray[i].checkBox = new String[MAX_QUESTIONS];

        }

        questionsArray[0].questionHeader = "How to pass the data between activities in Android?";
        questionsArray[1].questionHeader = "What is the life cycle of services in android?";
        questionsArray[2].questionHeader = "On which thread broadcast receivers will work in android?";
        questionsArray[3].questionHeader = "How to store heavy structured data in android?";
        questionsArray[4].questionHeader = "What is the application class in android?";
        questionsArray[5].questionHeader = "What are Intents and Intent Filters?";
        questionsArray[6].questionHeader = "What are the three fundamental cases of Intents?";
        questionsArray[7].questionHeader = "How many types of intents are there?";
        questionsArray[8].questionHeader = "What are the two types of intents?";
        questionsArray[9].questionHeader = "What is the package name of JSON?";

        questionsArray[0].checkBox[0]  = "Intent";
        questionsArray[0].checkBox[1] = "Content Provider";
        questionsArray[0].checkBox[2]  = "Broadcast receiver";
        questionsArray[0].checkBox[3]  = "None of the Above ";
        questionsArray[0].maxNumCheckbox = 4;
        questionsArray[0].answer = 0;

        questionsArray[1].checkBox[0]  = "onCreate()−>onStartCommand()−>onDestory()";
        questionsArray[1].checkBox[1] = "onRecieve()";
        questionsArray[1].checkBox[2]  = "onRecieve()";
        questionsArray[1].checkBox[3]  = "Service life cycle is same as activity life cycle. ";
        questionsArray[1].maxNumCheckbox = 4;
        questionsArray[1].answer = 0;

        questionsArray[2].checkBox[0]  = "Worker Thread";
        questionsArray[2].checkBox[1] = "Main Thread";
        questionsArray[2].checkBox[2]  = "Activity Thread";
        questionsArray[2].checkBox[3]  = "None of the Above ";
        questionsArray[2].maxNumCheckbox = 4;
        questionsArray[2].answer = 1;

        questionsArray[3].checkBox[0]  = "Shared Preferences.";
        questionsArray[3].checkBox[1] = "Cursor";
        questionsArray[3].checkBox[2]  = "SQlite database ";
        questionsArray[3].checkBox[3]  = "Not possible";
        questionsArray[3].maxNumCheckbox = 4;
        questionsArray[3].answer = 2;


        questionsArray[4].checkBox[0]  = "A class that can create only an object";
        questionsArray[4].checkBox[1] = "Anonymous class";
        questionsArray[4].checkBox[2]  = "Java class";
        questionsArray[4].checkBox[3]  = " Base class for all classes";
        questionsArray[4].maxNumCheckbox = 4;
        questionsArray[4].answer = 3;

        questionsArray[5].checkBox[0]  = "";
        questionsArray[5].checkBox[1] = "An Intent is a messaging object you can use to request an action from another app component.";
        questionsArray[5].checkBox[2]  = "";
        questionsArray[5].checkBox[3]  = "";
        questionsArray[5].maxNumCheckbox = 4;
        questionsArray[5].answer = 1;

        questionsArray[6].checkBox[0]  = "";
        questionsArray[6].checkBox[1] = "Starting an activity, Starting a service, Delivering a broadcast";
        questionsArray[6].checkBox[2]  = "Q 2 answer 3";
        questionsArray[6].checkBox[3]  = "Q 2 answer 4";
        questionsArray[6].maxNumCheckbox = 4;
        questionsArray[6].answer = 1;

        questionsArray[7].checkBox[0]  = "Question 3 answer";
        questionsArray[7].checkBox[1] = "There are two types of intents. ";
        questionsArray[7].checkBox[2]  = "Q 3 answer 3";
        questionsArray[7].checkBox[3]  = "Q 3 answer 4";
        questionsArray[7].maxNumCheckbox = 4;
        questionsArray[7].answer = 2;

        questionsArray[8].checkBox[0]  = "Question 4 answer";
        questionsArray[8].checkBox[1] = " Explicit intents, Implicit intents";
        questionsArray[8].checkBox[2]  = "Q 4 answer 3";
        questionsArray[8].checkBox[3]  = "Q 4 answer 4";
        questionsArray[8].maxNumCheckbox = 4;
        questionsArray[8].answer = 2;

        questionsArray[9].checkBox[0]  = "com.json";
        questionsArray[9].checkBox[1] = "in.json";
        questionsArray[9].checkBox[2]  = "com.android.JSON";
        questionsArray[9].checkBox[3]  = "org.json";
        questionsArray[9].maxNumCheckbox = 4;
        questionsArray[9].answer = 3;

    }

    public void setArraysIndex(){
        arrayIndex = 0;
        checkBoxIndex = 0;
    }

    public int getTotalNumberOfQuestions(){
        return MAX_QUESTIONS;
    }

    public int getAnswer(){
        return questionsArray[arrayIndex].answer;
    }

    public String getQuestionHeader (){
        if(arrayIndex < MAX_QUESTIONS){
            return questionsArray[arrayIndex].questionHeader;
        }
        return null;
    }

    public String getCheckboxText(){
        return questionsArray[arrayIndex].checkBox[checkBoxIndex];
    }

    public int maxNumCheckbox(){
        return questionsArray[arrayIndex].maxNumCheckbox;
    }

    public void nextCheckboxIndex(){
        if(checkBoxIndex < questionsArray[arrayIndex].maxNumCheckbox){
            checkBoxIndex++;
        }
    }

    public void nextIndex(){
        if(arrayIndex < MAX_QUESTIONS) {
            arrayIndex++;
            checkBoxIndex = 0;
        }
    }

    public int getArrayIndex(){

        return arrayIndex;
    }

    public String getShortAnswer(){

        return questionsArray[arrayIndex].checkBox[0];

    }

    class QuestionObject{
        public String questionHeader;
        String[] checkBox;
        int answer;
        int maxNumCheckbox;
    }
}


package com.alfredo.androidterminologyquiz;
/**
 * Created by alfred on 11/9/16.
 */


public class QuestionSet
{
    private static final int MAX_QUESTIONS = 4;
    QuestionObject[] questionsArray;
    int arrayIndex = 0;
    int checkBoxIndex = 0;

    QuestionSet(){
        setQuestions();
    }

    public void setQuestions(){

        questionsArray = new QuestionObject[MAX_QUESTIONS];

        questionsArray[0] = new QuestionObject();
        questionsArray[1] = new QuestionObject();
        questionsArray[2] = new QuestionObject();
        questionsArray[3] = new QuestionObject();

        for (int i = 0; i < MAX_QUESTIONS; i++){
         questionsArray[i].checkBox = new String[MAX_QUESTIONS];
        }

        questionsArray[0].questionHeader = "What are Intents and Intent Filters?";
        questionsArray[1].questionHeader = "What are the three fundamental cases of Intents?";
        questionsArray[2].questionHeader = "How many types of intents are there?";
        questionsArray[3].questionHeader = "What are the two types of intents?";

        questionsArray[0].checkBox[0]  = "Question 1 answer";
        questionsArray[0].checkBox[1] = "Q 1 Answer 2";
        questionsArray[0].checkBox[2]  = "Q 1 answer 3";
        questionsArray[0].checkBox[3]  = "Q 1 answer 4";
        questionsArray[0].maxNumCheckbox = 4;
        questionsArray[0].answer = 2;

        questionsArray[1].checkBox[0]  = "Question 2 answer";
        questionsArray[1].checkBox[1] = "Q 2 Answer 2";
        questionsArray[1].checkBox[2]  = "Q 2 answer 3";
        questionsArray[1].checkBox[3]  = "Q 2 answer 4";
        questionsArray[1].maxNumCheckbox = 4;
        questionsArray[1].answer = 2;

        questionsArray[2].checkBox[0]  = "Question 3 answer";
        questionsArray[2].checkBox[1] = "Q 3 Answer 2";
        questionsArray[2].checkBox[2]  = "Q 3 answer 3";
        questionsArray[2].checkBox[3]  = "Q 3 answer 4";
        questionsArray[2].maxNumCheckbox = 4;
        questionsArray[2].answer = 2;

        questionsArray[3].checkBox[0]  = "Question 4 answer";
        questionsArray[3].checkBox[1] = "Q 4 Answer 2";
        questionsArray[3].checkBox[2]  = "Q 4 answer 3";
        questionsArray[3].checkBox[3]  = "Q 4 answer 4";
        questionsArray[3].maxNumCheckbox = 4;
        questionsArray[3].answer = 2;
    }

//    public void setMediumQuestions(){
//
//        questionsArray[0].questionHeader = "What are Intents and Intent Filters?";
//        questionsArray[1].questionHeader = "What are the three fundamental cases of Intents?";
//        questionsArray[2].questionHeader = "How many types of intents are there?";
//        questionsArray[3].questionHeader = "What are the two types of intents?";
//
//        questionsArray[0].checkBox[0]  = "Question 1 answer";
//        questionsArray[0].checkBox[1] = "Q 1 Answer 2";
//        questionsArray[0].checkBox[2]  = "Q 1 answer 3";
//        questionsArray[0].checkBox[3]  = "Q 1 answer 4";
//        questionsArray[0].maxNumCheckbox = 4;
//        questionsArray[0].answer = 2;
//
//        questionsArray[1].checkBox[0]  = "Question 2 answer";
//        questionsArray[1].checkBox[1] = "Q 2 Answer 2";
//        questionsArray[1].checkBox[2]  = "Q 2 answer 3";
//        questionsArray[1].checkBox[3]  = "Q 2 answer 4";
//        questionsArray[1].maxNumCheckbox = 4;
//        questionsArray[1].answer = 2;
//
//        questionsArray[2].checkBox[0]  = "Question 3 answer";
//        questionsArray[2].checkBox[1] = "Q 3 Answer 2";
//        questionsArray[2].checkBox[2]  = "Q 3 answer 3";
//        questionsArray[2].checkBox[3]  = "Q 3 answer 4";
//        questionsArray[2].maxNumCheckbox = 4;
//        questionsArray[2].answer = 2;
//
//        questionsArray[3].checkBox[0]  = "Question 4 answer";
//        questionsArray[3].checkBox[1] = "Q 4 Answer 2";
//        questionsArray[3].checkBox[2]  = "Q 4 answer 3";
//        questionsArray[3].checkBox[3]  = "Q 4 answer 4";
//        questionsArray[3].maxNumCheckbox = 4;
//        questionsArray[3].answer = 2;
//    }


    public String getEasyQuestion (){
            return questionsArray[arrayIndex].questionHeader;
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

    class QuestionObject{

        public String questionHeader;
        String[] checkBox;
        int answer;
        int maxNumCheckbox;
    }
}

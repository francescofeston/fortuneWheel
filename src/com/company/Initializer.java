package com.company;
import java.util.ArrayList;
public class Initializer {

    private String sentence;
    private int sentenceLen;

    public Initializer(){

    }
    public int initSentence(){
        sentence = "Hello World";
        sentence = sentence.toUpperCase();
        sentenceLen = sentence.length();
        shwMsg("Game is ready. Start playing");
        return sentenceLen;
    }

    public ArrayList<Integer> receiveGuess(char inputChar){  //keep track of the matching position. It holds all the indexes where the matches occur
        inputChar = Character.toUpperCase(inputChar);

        ArrayList<Integer> idxList = new ArrayList<>();
        for(int i = 0; i < sentenceLen; i++){
            if(sentence.charAt(i) == inputChar){
                idxList.add(i);
            }
        }
        return idxList;
    }
    public void shwMsg(String msg){
        System.out.println(msg);
    }
}

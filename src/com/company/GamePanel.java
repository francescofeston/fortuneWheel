package com.company;


import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
it coordinates interaction between initializer and player
 */
public class GamePanel {

    private Initializer initializer;
    private Player[] playerAry;
    private int numPlayer;
    private int currPlayer;
    private Board board;

    public GamePanel(){
        numPlayer = 3;
        currPlayer = 0;
        initComponent();
    }

    public void startGame(){
        ArrayList<Integer> idxList; // one letter may have multiple matches
        boolean gameDone = false;
        boolean guessValid;
        char playerGuess;
        int wheelScore;
        boolean exist;

        shwMsg("Game is ready. Start playing");

        while(!gameDone){ //allows next playe
            currPlayer = playerAry[currPlayerIdx];
            guessValid = true;
            while (guessValid){ //current player continues
                showMsgSameLine(currPlayer.getName() + " is playing: ");
                wheelScore = currPlayer.turnWheel();
                showMsgSameLine("wheel score is " + wheelScore + ". ");

                //player goes bankrupt
                if(wheelScore < 0){
                    currPlayer.setTotalScore(0);
                    showMsgSameLine(currPlayer.getName() + " is Bankrupt.");
                    shwMsg("Current score: " + currPlayer.getTotalScore());
                    break; //next player takes turn
                }
                //player does not bankrupt
                playerGuess = currPlayer.inputGuess;
                idxList = initializer.receiveGuess(playerGuess);
                //player's guessed char mismatch, break
                if(idxList.isEmpty()){
                    showMsgSameLine("'" + playerGuess + "' is mismatch.");
                    shwMsg("Current score: " + currPlayer.getTotalScore());
                    break;
                }
                //player's guessed char matches. Insert the guessed char into board for displaying
                exist = board.insertCurrAry(idxList, playerGuess);
                // the guessed char exists already, break
                if(exist){
                    showMsgSameLine("'" + playerGuess + " already exists");
                    shwMsg("Current score: " + currPlayer.getTotalScore());
                    break;
                }
                //the guessed char does not exist, best case-
                //calculate current player's total score
                wheelScore = idxList.size() * wheelScore;
                showMsgSameLine("'" + playerGuess + " is a match");
                //add wheel score to player's total score
                currPlayer.setTotalScore(currPlayer.getTotalScore() + wheelScore);
                shwMsg("Current score: " + currPlayer.getTotalScore());
                //show the board

                board.showBoard();
            }
        }
    }

    public void initComponent(){
        initPlayer();
        initializer = new Initializer();
        initializer.initSentence();

        startGame();
    }

    public void initPlayer(){
        playerAry = new Player[numPlayer];
        for(int i = 0; i < numPlayer; i++){
            playerAry[i] = new Player();
            playerAry[i].setName(initPlayerData(i,"name"));
            playerAry[i].setSex(initPlayerData(i, "sex"));
            playerAry[i].setNumPlay(0);
            playerAry[i].setScore(0);
        }
    }

    public String initPlayerData(int idx, String title){
        boolean hasInput = false;
        String titleStr = "";
        char isEmpty;

        String numTh = "first";
        switch (idx){
            case 0:
                numTh = "first";
                break;
            case 1:
                numTh = "second";
                break;
            case 2:
                numTh = "third";
                break;
        }
        while(!hasInput){
            titleStr = JOptionPane.showInputDialog("Enter " + numTh + "player's" + title);
            try{
                isEmpty = titleStr.charAt(0);
                hasInput = true;
            }catch (StringIndexOutOfBoundsException siex){
                shwMsg("You did not input the " + title + ". Input again." );
            }catch (NullPointerException npex){
                shwMsg("You clicked cancel.");
                abortGame();
            }

        }
        return titleStr;
    }

    public void startGame() {
        ArrayList<Integer> idxList; //one letter may have multiple matches
        boolean guessValid;
        char playerGuess;

        while (currPlayer < 3) {  //allows next player
            guessValid = true;
            shwMsg("The current player " + playerAry[currPlayer].getName() + " is playing");
            while (guessValid) { //current player continues
                playerGuess = playerAry[currPlayer].inputGuess();
                idxList = initializer.receiveGuess(playerGuess);
                if (idxList.isEmpty()) { //guess has no match
                    shwMsg("The guessed char" + playerGuess + " matches 0 character in the sentence.");
                    guessValid = false; // next player takes turn
                } else {
                    shwMsg ("The guessed char" + playerGuess + " matches " + idxList.size() + " character(s) in the sentence");
                }
            }
            currPlayer = (currPlayer + 1) % numPlayer; //switch to next player
        }
    }
    public void abortGame(){
        shwMsg("The game is aborted");
        System.exit(0);
    }
    public void shwMsg(String msg){
        System.out.println(msg);
    }
}

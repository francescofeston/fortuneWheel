package com.company;

public class Player {

    private String name;
    private String sex;
    private Wheel wheel;

    public int turnWheel(){
        String wheelScoreStr;
        int wheelScore;
        wheelScoreStr = wheel.wheelTurns();
        if(!(wheelScoreStr.equals("Bankrupt"))){
            wheelScore = Integer.parseInt(wheelScoreStr);
        }else{
            wheelScore = -1;
        }
        return wheelScore;
    }

    public void setWheel(Wheel wheel){
        this.wheel = wheel;
    }

    public String getName(){
        return name;
    }
}

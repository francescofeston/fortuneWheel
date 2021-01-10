/*
package com.company;

import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.swing.JOptionPane;

public class ReadFile {
    FileReader inputFile;
    String filePath;
    String fileName;

    public ReadFile(){

    }

    public void selectFile(){
        Object[] selectionValues = {"wheel1.txt", "wheel2.txt"}; //array of object for storing 2 file names
        String initialSelection = "";
        Object selection = JOptionPane.showInputDialog(null, "Select the file you would like to use",
                "Select a file", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        filePath = "../txt/" + selection;
        URL url = getClass().getResource(filePath);
        fileName = url.getPath();

        try{ //create object of file Reader
            inputFile = new FileReader(fileName);

        }catch (FileNotFoundException fex){

        }
    }

    public String readContent(){
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        String line = null;
        int numLines = 3; //indicates that the text file contains 3 lines
        int lineNum;
        int count;

        lineNum = (int)(Math.random() * numLines); //generates a random int [0,(3-1)] for randomly picking up one of 3 lines
        try {
            count = 0;
            while((line = bufferedReader.readLine()) != null){
                if(count == lineNum) { //reach the random line
                    break;
                }
                count++;
            }
            bufferedReader.close();
        } catch (IOException ioex){

        }
        return line;
    }
}

 */

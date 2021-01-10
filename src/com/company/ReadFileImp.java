package com.company;
import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.swing.JOptionPane;

public class ReadFileImp {
    FileReader inputFile;
    String filePath;
    String fileName;

    public ReadFileImp() {

    }
    public void selectFile() {
        String aFileName = JOptionPane.showInputDialog("Please enter a file name for reading(e.g. wheel1.txt)");
        filePath = "../txt/" + aFileName;
        URL url = getClass().getResource(filePath);
        fileName = url.getPath();

        try { //create Obj of fileReader

            inputFile = new FileReader(fileName);
        } catch (FileNotFoundException fex) {

        }
    }

    public String readContent(){
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        String line = null;
        int numLines;
        int lineNum;
        int count;

        String lineNumStr = JOptionPane.showInputDialog("How many lines in the file? (an integer)");
        numLines = Integer.parseInt(lineNumStr);
        lineNum = (int) (Math.random() * numLines);
        try{
            count = 0;
            while ((line = bufferedReader.readLine()) != null){
                if(count == lineNum){
                    break;
                }
                count++;
            }
            bufferedReader.close();
        }catch (IOException ioex){

        }
        return line;
    }
}
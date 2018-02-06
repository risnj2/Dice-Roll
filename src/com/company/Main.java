package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static Scanner read = new Scanner(System.in);
    public static Random rand = new Random();
    public static int beginFile = 0;

    public static void main(String[] args) {
        System.out.println("Enter in the Die Type you want");
        System.out.println("Type in 'q' to exit");
        beginFile = 1;
        while(true){
            try{
                String input = read.next();
                if(input.equals("q") || input.equals("Q")){
                    System.exit(0);
                }
                else{
                    int DieType = Math.round(Math.abs(Integer.parseInt(input)));
                    if(DieType == 4 || DieType == 6 || DieType == 8 || DieType == 12 || DieType == 20 || DieType == 100){
                        String rollResult = "This D" + DieType + " roll is: " + Math.round(rand.nextInt(DieType) + 1);
                        System.out.println(rollResult);
                        WritingToFile(rollResult,beginFile);
                    }
                    else{
                        System.out.println("Number input was not a valid dice, please enter again");
                    }
                }
            }
            catch(Exception e){
                System.out.print(e + "\nSorry, an error occurred, please try again\n");
            }
        }
    }
    public static void ChanceRoller(int MaxNum){
        System.out.print(Math.round(rand.nextInt(MaxNum) + 1));
    }
    public static void WritingToFile(String text, int begin) throws IOException{
        String timeStampDate = new SimpleDateFormat("dd:MM:yyyy").format(new java.util.Date());
        String timeStampHour = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        PrintWriter output2 = new PrintWriter(new FileWriter("DiceRollOutput.txt",true));
        if (begin == 1){
            output2.println("\n");
            output2.println("---- Began New Recording On {" + timeStampDate + "} at {" + timeStampHour + "} ----");
            beginFile = 0;
        }
        output2.println(text + " ----- TimeStamp{" + timeStampHour + "}");
        output2.close();


        /*
        Other ways

        1.Rewrites whats written
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(text);
        writer.close();

        2.No New Line
        Writer output;
        output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OutputTrial.txt",true),"UTF-8"));
        output.write(text);
        output.close();
        */
    }
}

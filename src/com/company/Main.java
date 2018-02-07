package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static Scanner read = new Scanner(System.in);
    public static Random rand = new Random();
    public static int beginFile = 0;

    public static void main(String[] args) {
        System.out.println("Type in 'q' to exit the program");
        beginFile = 1;
        while(true){
            try{
                String input;
                System.out.println("Enter in the name of the roller if you wish to by pressing 1,\nOtherwise just press any other letter or number");
                String charName = "No Name";
                input = read.next();
                if(input.equals("1")){
                    System.out.println("Enter in the name");
                    charName = read.next();
                }
                if(input.equals("q") || input.equals("Q")){
                    System.exit(0);
                }
                else{
                    System.out.println("Enter in the Die Type you want");
                    input = read.next();
                    int DieType = Math.round(Math.abs(Integer.parseInt(input)));
                    if(DieType == 4 || DieType == 6 || DieType == 8 || DieType == 12 || DieType == 20 || DieType == 100){
                        int numRolled = Math.round(rand.nextInt(DieType) + 1);
                        if(!charName.equals("No Name")){
                            WritingResult(Integer.toString(numRolled),charName,beginFile,DieType);
                        }
                        else{
                            WritingResult(Integer.toString(numRolled),beginFile,DieType);
                        }
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
    public static void WritingResult(String diceOutcome,String charName, int begin, int diceType) throws IOException{
        String printedResult = "Player " + charName + " has rolled a D" + diceType + " for a result of: " + diceOutcome;
        System.out.println(printedResult);
        String timeStampDate = new SimpleDateFormat("MM:dd:yyyy").format(new java.util.Date());
        String timeStampHour = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        PrintWriter output = new PrintWriter(new FileWriter("DiceRollOutput.txt",true));
        if (begin == 1){
            output.println("\n");
            output.println("---- Began New Recording On {" + timeStampDate + "} at {" + timeStampHour + "} ----");
            beginFile = 0;
        }
        output.println("TimeStamp{" + timeStampHour + "} ----- " + printedResult);
        output.close();
    }
    public static void WritingResult(String diceOutcome, int begin, int diceType) throws IOException{
        String printedResult = "This D" + diceType + " roll is a: " + diceOutcome;
        System.out.println(printedResult);
        String timeStampDate = new SimpleDateFormat("MM:dd:yyyy").format(new java.util.Date());
        String timeStampHour = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        PrintWriter output = new PrintWriter(new FileWriter("DiceRollOutput.txt",true));
        if (begin == 1){
            output.println("\n");
            output.println("---- Began New Recording On {" + timeStampDate + "} at {" + timeStampHour + "} ----");
            beginFile = 0;
        }
        output.println("TimeStamp{" + timeStampHour + "} ----- " + printedResult);
        output.close();

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

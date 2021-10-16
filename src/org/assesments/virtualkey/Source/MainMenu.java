package org.assesments.virtualkey.Source;

//import javax.swing.*;

import javax.swing.*;
import java.util.Scanner;

public class MainMenu {
    FileOperations fo = new FileOperations();
    Scanner sc = new Scanner(System.in);
    public void WelcomeOutput(){
        System.out.println("=======================================================");
        System.out.println("********************* WELCOME *************************");
        System.out.println("---------Virtual Key for Your Repositories-------------");
        System.out.println("                                   Developer -> Rohit.P");
        System.out.println("=======================================================");
        options();

    }

    public void options(){
        System.out.println("1 ->Display files available");
        System.out.println("2 ->Additional file options");
        System.out.println("3 -> Exit out of the application");
        Select();
    }


    public int userInput(){

        String choice = sc.next();
        try
        {
            int x = Integer.parseInt(choice);
            return x;
        }
        catch (Exception e){
            return  -1;
        }


    }
    private void Select() {
        try{
            System.out.println("Enter your choice: ");
           int choice = userInput();
            if(choice==-1)
                choice=4;



        switch(choice) {
            case 1:
                fo.ShowFiles();
                options();
                break;
            case 2:
                fo.Display();
                options();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Enter a valid options");
                options();
        }

        }
        catch(Exception E){
            System.out.println("Enter a numberic number ");
            sc.close();

        }



        }





    public static void main(String[] args) {

        MainMenu MM = new MainMenu();
        MM.WelcomeOutput();


    }
}

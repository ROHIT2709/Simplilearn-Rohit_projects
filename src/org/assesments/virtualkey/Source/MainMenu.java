package org.assesments.virtualkey.Source;

//import javax.swing.*;

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

    private void Select() {
        int choice = sc.nextInt();
        switch(choice){
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



        }


    }


    public static void main(String[] args) {

        MainMenu MM = new MainMenu();
        MM.WelcomeOutput();


    }
}

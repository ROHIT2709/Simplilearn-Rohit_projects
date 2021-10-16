package org.assesments.virtualkey.Source;

import org.assesments.virtualkey.Folder.FolderPathAndOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations implements Selections {
    Scanner sc = new Scanner(System.in);


    private FolderPathAndOperations Directory = new FolderPathAndOperations();

    @Override
    public void Display() {
        System.out.println("1 -> Add a File");
        System.out.println("2 -> Delete A File");
        System.out.println("3 -> Search A File");
        System.out.println("4 -> Revert to options");
        System.out.println("Enter your option");
        int n = sc.nextInt();
        Choices(n);


    }


    @Override
    public void Choices(int option) {


        switch (option) {

            case 1:
                this.Add();

                this.Display();
                break;
            case 2:
                this.Delete();

                this.Display();
                break;
            case 3:
                this.Search();
                this.Display();
                break;


            case 4:
                // m.options();
                break;

            default:
                System.out.println("Invalid Option");
                break;


        }

    }

    private File findfile(String title) {
        for (File checkedFiles : Directory.FileList()) {
            if (checkedFiles.getName().equalsIgnoreCase(title)) {
                return checkedFiles;
            }
        }
        return null;
    }

    public void Add() {
        System.out.println("Enter the name for the file you are about to create: ");

        String fileName = sc.next();


        try {

            Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
            File file = new File(Directory.getName() + fileName);
            if (findfile(fileName) != null)
                System.out.println(":::: File already exist in the directory :::: ");

            else {
                if (file.createNewFile()) {
                    System.out.println("File is created -> " + file.getName());
                    Directory.FileList().add(file);

                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public void Delete() {

        System.out.println("Please Enter the Filename:");

        String fileName = sc.next();

        System.out.println("deleting.... " + fileName);
        if (findfile(fileName) == null)
            System.out.println(":::: File you are trying to delete does not exist in the directory ,FNF(File not found) :::: ");


        Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println("Deleted file -> " + file.getName());
            Directory.FileList().remove(file);
        }
    }

    public void ShowFiles() {

        int count =1;
        System.out.println("List of Files: ");
        for(File names:Directory.FileList())
        {
            System.out.println( count+" "+names.getName());
            count++;
        }

    }

    public void Search() {

        Boolean found = false;

        System.out.println("Please enter the file that you want to search ");

        String fileName = sc.next();

        System.out.println("Searching for..... " + fileName);
        if (findfile(fileName) == null) {
            System.out.println("This file " + fileName+ " is not present ");

        } else {
            System.out.println(fileName + " found  in the directory ");


        }


    }
}

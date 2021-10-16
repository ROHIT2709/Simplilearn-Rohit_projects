package org.assesments.virtualkey.Folder;


import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class FolderPathAndOperations {


    public static final String name = "main/Saved_texts/";

    private ArrayList<File> listoffiles = new ArrayList<File>();

    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();

    File Sfiles = path.toFile();

    public String getName() {
        return name;

    }



    public ArrayList<File> FileList() {
        File[] directoryFiles = Sfiles.listFiles();



        listoffiles.clear();
        for (int i = 0; i < directoryFiles.length; i++) {
            if (directoryFiles[i].isFile()) {
                listoffiles.add(directoryFiles[i]);
            }
        }

        Collections.sort(listoffiles);

        return listoffiles;
    }


    @Override
    public String toString() {
        return getName();
    }

}




















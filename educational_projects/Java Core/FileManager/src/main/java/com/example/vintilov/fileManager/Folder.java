package com.example.vintilov.fileManager;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Print {
    private String folderName;
    private List<File> files = new ArrayList<File>();


    Folder(String folderName) {
        this.folderName = folderName;
    }

    Folder(String folderName, File file) {
        this.folderName = folderName;
        files.add(file);
    }


    public boolean addFile(File file) {
        files.add(file);
        return true;
    }

    public void print() {
        System.out.println(folderName + ": ");
        for (File file : files) {
            file.print();
        }

    }

}

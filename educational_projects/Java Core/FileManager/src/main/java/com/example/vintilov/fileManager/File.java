package com.example.vintilov.fileManager;


public class File implements Print {
    private String nameFile;


    File(String nameFile) {
        this.nameFile = nameFile;
    }


    public void print() {
        System.out.println("\t\t" + nameFile);
    }
}

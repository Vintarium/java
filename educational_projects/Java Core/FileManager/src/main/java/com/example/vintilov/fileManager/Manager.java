package com.example.vintilov.fileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Manager {
    private  List<Session> sessions = new ArrayList<Session>();
    private  Session session = new Session();



    public void operationWithString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the folder name, then </>, then the next folder name, and so on, then press Enter. ");
        String string = scanner.nextLine();

        if (string.toCharArray().length == 0){
            throw new IllegalArgumentException("An empty line was entered.Try again.");
        }


        Pattern pattern = Pattern.compile("\\w+\\.txt");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {

            String file = getFileFromString(string, searchFileInString(string));
            String stringWithoutFile = cutFileOfString(string, searchFileInString(string));
            String[] foldersInArray = splitString(stringWithoutFile);


            for (int i = 0; i < foldersInArray.length; i++) {
                session.addFile(new Folder(foldersInArray[i]));
                if (i == foldersInArray.length - 1) {
                    session.removeLastIndex();
                    session.addFile(new Folder(foldersInArray[i], new File(file)));
                }
            }
            sessions.add(session);
        } else {
            String[] foldersInArray = splitString(string);
            for (int i = 0; i < foldersInArray.length; i++) {
                session.addFile(new Folder(foldersInArray[i]));
            }
            sessions.add(session);
        }

    }


    private  String[] splitString(String string) {
        return string.split("/");

    }


    private  int[] searchFileInString(String string) {
        int[] arr = new int[2];
        int endFile = string.lastIndexOf(".txt");
        int startFile = string.lastIndexOf("/");
        arr[0] = endFile;
        arr[1] = startFile;
        return arr;
    }

    private  String getFileFromString(String string, int[] arr) {
        return string.substring(arr[1] + 1, arr[0]);


    }

    private  String cutFileOfString(String string, int[] arrays) {
        String buffer = string.substring(arrays[1], arrays[0]);
        string = string.replace(buffer + ".txt", "");
        return string;

    }

}

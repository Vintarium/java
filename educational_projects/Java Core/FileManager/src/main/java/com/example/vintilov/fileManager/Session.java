package com.example.vintilov.fileManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Session {
    private static List<Folder> folders = new ArrayList();
    private static final String MESSAGE_EXCEPTION = "This operation cannot be performed because " +
            "the hierarchy is still empty. Fill in the hierarchy and try again.";


    public boolean addFile(Folder folder) {
        folders.add(folder);
        return true;
    }

    private boolean checkForZero(int size) {
        if (size == 0) {
            throw new IllegalArgumentException(MESSAGE_EXCEPTION);
        }
        return true;
    }


    public boolean print() {
        checkForZero(folders.size());
        for (Folder folder : folders) {
            folder.print();
        }
        System.out.println();
        return true;
    }


    public boolean removeLastIndex() {
        checkForZero(folders.size());
        folders.remove(folders.size() - 1);
        return true;
    }

    public boolean remove() {
        checkForZero(folders.size());
        Iterator<Folder> folderIterator = folders.iterator();
        while (folderIterator.hasNext()) {
            Folder nextFolder = folderIterator.next();
            folderIterator.remove();
        }
        return true;
    }

    public boolean addFileToFolder() {
        checkForZero(folders.size());
        Scanner scanner = new Scanner(System.in);
        System.out.println("First enter the index, then a space, after" +
                "write the filename and press Enter.");
        int index = scanner.nextInt();
        String fileName = scanner.nextLine();

        folders.get(index).addFile(new File(fileName));
        return true;
    }

    public int getSize(){
        checkForZero(folders.size());
        return folders.size();

    }
}

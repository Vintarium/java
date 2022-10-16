package com.example.vintilov.fileManager;

import java.util.Scanner;

public class StartProgram {
    private Session session = new Session();
    private Manager manager = new Manager();


    public void begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Button 1 - create a folder / folders with a file");
        System.out.println("Button 2 - delete all");
        System.out.println("Button 3 - view what is");
        System.out.println("Button 4 - exit");
        System.out.println("Button 5 - add a file to an existing folder (by index)");
        int wayInt = scanner.nextInt();

        if (wayInt == 1) {
            manager.operationWithString();

        } else if (wayInt == 2) {
            session.remove();

        } else if (wayInt == 3) {
            session.print();

        } else if (wayInt == 4) {
            System.exit(1);

        } else if (wayInt == 5) {
            session.addFileToFolder();
        } else {
            throw new IllegalArgumentException("You have selected a command that does not exist, please try again");
        }
        begin();

    }
}

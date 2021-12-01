package com.rub.sel4;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack rooms = new Stack();
        rooms.push("Hallway");
        Scanner sc = new Scanner(System.in);
	    System.out.println("Welcome to your apartment.");
        boolean leaveApartment = false;
        do {
            // Room output
            System.out.println("You are in the " + rooms.peek() + ".\nWhat do you want to do?\n");
            // Choices Output
            int choices = 1;
            System.out.println("\t(" + choices + ") Switch light");
            choices++;
            System.out.println("\t(" + choices + ") Leave room");
            choices++;
            System.out.println("\t(" + choices + ") Enter neighbouring room");
            choices++;
            if(true/*room is kitchen*/) {
                System.out.println("\t(" + choices + ") Switch stove");
                choices++;
            }
            if(true/*room is bathroom*/) {
                System.out.println("\t(" + choices + ") Switch shower");
                choices++;
            }
            choices--;
            int input = sc.nextInt();
            switch(input) {
                case 1:

                    break;
                case 2:
                    if(rooms.peek().equals("Hallway")) {
                        leaveApartment = true;
                        break;
                    }
                    break;
                case 3:

                    break;
                case 4:
                    if(true/*room is kitchen*/) {

                    }
                    break;
                case 5:
                    if(true/*room is bathroom*/) {

                    }
                    break;
            }
        } while (!leaveApartment);
        System.out.println("You leaved the building");
    }
}

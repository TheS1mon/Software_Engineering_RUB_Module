package com.rub.sel2;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

/**
 * Software Engineering Lecture 2: Java
 * @author Simon Pohlenz, 108020218825, Group AG1001
 */
public class Main {

    static StudentList students = new StudentList();
    public static void main(String[] args) {


        //Student definitions
        Student s1 = new Student("Simon", "Pohlenz", 1, 80, new Date(2001, 6, 22));
        Student s2 = new Student("Peter", "Altmaier", 2, 200, new Date(1989, 7, 06));
        Student s3 = new Student("Markus", "Lanz", 3, 120, new Date(1989, 4, 13));
        Student s4 = new Student("Klaus", "Klaus", 4, 70, new Date(1988, 4, 11));
        Student s5 = new Student("Hannah", "Müller", 5, 70, new Date(2003, 1, 25));
        Student s6 = new Student("Julia", "Berg", 6, 65, new Date(2000, 6, 30));
        Student s7 = new Student("Marius", "Westernhagen", 7, 100, new Date(1960, 12, 18));
        Student s8 = new Student("Lucie", "Wagner", 8, 65, new Date(2002, 6, 04));
        Student s9 = new Student("Charlie", "Sheen", 9, 110, new Date(1980, 2, 13));
        Student s10 = new Student("Max", "Müller", 10, 90, new Date(1999, 4, 24));
        Student s11 = new Student("Gertrude", "Grusel", 11, 512, new Date(1920, 1, 01));
        // Adding students to the list
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        students.add(s10);
        students.add(s11);

        System.out.println("Copy Test:");
        // Creating a Copy of the StudentList
        StudentList copyOfStudents = new StudentList(students.getStudentList());

        /*      Test the copy: If the copy is a reference, then the same object would be deleted
                in both students and copyOfStudents, if you delete it in one of them.
                But in this example, Student 11 is still there in students.                      */
        copyOfStudents.remove(10);
        System.out.println("Element in students: " + students.get(10).toString());
        try {
            System.out.println("Element in copyOfStudents: " + copyOfStudents.get(10).toString());
        } catch (Exception ex) {
            System.out.println("Element in copyOfStudents: Existiert nicht!");
        }

        /* Sorting testing
        System.out.println(students.toString());
        students.sort(Student.SortKey.FIRSTNAME);
        System.out.println(students.toString());
        students.sort(Student.SortKey.LASTNAME);
        System.out.println(students.toString());
        students.sort(Student.SortKey.STUDENT_ID);
        System.out.println(students.toString());
        students.sort(Student.SortKey.BIRTHDAY);
        System.out.println(students.toString());
        students.sort(Student.SortKey.WEIGHT);
        System.out.println(students.toString()); */

        runInterface();
    }

    public static void runInterface() {


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int selection = 0;  // Read user input
        do {
            System.out.println("\n\n\nStudentenmanagementsystem by Simon. Wählen Sie eine Option:");
            System.out.println("\t(1) Vollständige Studentenliste ausgeben");
            System.out.println("\t(2) Studenten hinzufügen");
            System.out.println("\t(3) Studenten entfernen");
            System.out.println("\t(4) Liste sortieren");
            System.out.println("\t(5) Studentendata ausgeben");
            System.out.println("\t(6) Studierendenposition in der Liste basierend auf ID ausgeben");
            System.out.println("\t(7) Prüfen, ob Student existiert");
            System.out.print("Nummer: ");
            try {
                selection = Integer.parseInt(myObj.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Nur Zahlen eingeben!");
            }

            System.out.println("Eingegebene Nummer " + selection);

            try {
                switch (selection) {
                    case 1: // Vollständige Studentenliste ausgeben
                        System.out.flush();
                        System.out.println(students.toString());
                        break;
                    case 2: // Studenten hinzufügen
                        System.out.flush();
                        System.out.print("Vorname: ");
                        String firstname = myObj.nextLine();
                        System.out.print("Nachname: ");
                        String lastname = myObj.nextLine();
                        System.out.print("Gewicht (kg): ");
                        double weight = Double.parseDouble(myObj.nextLine());
                        System.out.print("Geburtsjahr: ");
                        int birthdayYear = Integer.parseInt(myObj.nextLine());
                        System.out.print("Geburtsmonat: ");
                        int birthdayMonth = Integer.parseInt(myObj.nextLine());
                        System.out.print("Geburtstag: ");
                        int birthdayDay = Integer.parseInt(myObj.nextLine());
                        students.add(new Student(firstname, lastname, students.getNextFreeID(), weight, new Date(birthdayYear, birthdayMonth, birthdayDay)));
                        System.out.println("Student erfolgreich erstellt.");
                        break;
                    case 3: // Studenten entfernen
                        System.out.print("Listenposition des Studenten (1 - " + students.size() + "): ");
                        students.remove(Integer.parseInt(myObj.nextLine()));
                        System.out.println("Student gelöscht!");
                        break;
                    case 4: // Liste sortieren
                        System.out.print("Sort Key eingeben, SortKeys:\n\t(1) FIRSTNAME,\n\t(2) LASTNAME,\n\t(3) STUDENT_ID,\n\t(4) WEIGHT,\n\t(5) BIRTHDAY\n: ");
                        int sortKey = Integer.parseInt(myObj.nextLine());
                        switch (sortKey) {
                            case 1:
                                students.sort(Student.SortKey.FIRSTNAME);
                                break;
                            case 2:
                                students.sort(Student.SortKey.LASTNAME);
                                break;
                            case 3:
                                students.sort(Student.SortKey.STUDENT_ID);
                                break;
                            case 4:
                                students.sort(Student.SortKey.WEIGHT);
                                break;
                            case 5:
                                students.sort(Student.SortKey.BIRTHDAY);
                                break;
                        }
                        System.out.println(students.toString());
                        break;
                    case 5: // Studentendata ausgeben
                        System.out.print("Listenposition des Studenten (1 - " + students.size() + "): ");
                        System.out.println(students.get(Integer.parseInt(myObj.nextLine()) - 1).toString());
                        break;
                    case 6: // Studierendenposition in der Liste basierend auf ID ausgeben
                        System.out.print("ID des Studenten (1 - " + students.size() + "): ");
                        System.out.println(" Studentenposition in der Liste: " + (students.findStudentId(Integer.parseInt(myObj.nextLine())) + 1));
                        break;
                    case 7: // Prüfen, ob Student existiert
                        System.out.print("ID des Studenten (1 - " + students.size() + "): ");
                        if(students.findStudentId(Integer.parseInt(myObj.nextLine())) != -1) {
                            System.out.println("The student exists :).");
                        }
                        else {
                            System.out.println("The student does not exist :(.");
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Fehlerhafte Eingabe: " + e.getMessage());
            }
            System.out.flush();
            myObj.reset();
        } while (true);
    }
}

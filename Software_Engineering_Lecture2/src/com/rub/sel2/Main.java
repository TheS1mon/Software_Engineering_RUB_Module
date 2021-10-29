package com.rub.sel2;

import java.io.Console;
import java.util.Date;
import java.util.ArrayList;

/**
 * Software Engineering Lecture 2: Java
 * @author Simon Pohlenz, 108020218825, Group AG1001
 */
public class Main {

    public static void main(String[] args) {
        StudentList students = new StudentList();

        //Student definitions
        Student s1 = new Student("Simon", "Pohlenz", 1, 80, new Date(2001, 06, 22));
        Student s2 = new Student("Peter", "Altmaier", 2, 200, new Date(1989, 07, 06));
        Student s3 = new Student("Markus", "Lanz", 3, 120, new Date(1989, 04, 13));
        Student s4 = new Student("Klaus", "Klaus", 4, 70, new Date(1988, 04, 11));
        Student s5 = new Student("Hannah", "Müller", 5, 70, new Date(2003, 01, 25));
        Student s6 = new Student("Julia", "Berg", 6, 65, new Date(2000, 06, 30));
        Student s7 = new Student("Marius", "Westernhagen", 7, 100, new Date(1960, 12, 18));
        Student s8 = new Student("Lucie", "Wagner", 8, 65, new Date(2002, 06, 04));
        Student s9 = new Student("Charlie", "Sheen", 9, 110, new Date(1980, 02, 13));
        Student s10 = new Student("Max", "Müller", 10, 90, new Date(1999, 04, 24));
        Student s11 = new Student("Gertrude", "Grusel", 11, 512, new Date(1920, 01, 01));
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
        System.out.println("\n\n\nStudentenmanagementsystem by Simon. Wählen Sie eine Option:");
        System.out.println("\t(1) Vollständige Studentenliste ausgeben");

        Console console = System.console();

        if(console == null) {
            System.out.println("Console is not available to current JVM process");
            return;
        }

        String selection = console.readLine("\nNummer: ");
        System.out.println("Eingegebene Nummer " + selection);
    }
}

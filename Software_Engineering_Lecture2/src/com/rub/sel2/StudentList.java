package com.rub.sel2;

import java.util.ArrayList;

/**
 * Software Engineering Lecture 2: Java
 * @author Simon Pohlenz, 108020218825, Group AG1001
 */
public class StudentList {
    private ArrayList<Student> students;

    // Constructors
    public StudentList() {
        this.students = new ArrayList<Student>();
    }
    public StudentList(ArrayList<Student> newList) {
        this.students = new ArrayList<Student>(newList);
    }

    // Methods
    /**
     * adds student to the list, if the list does not yet contain a student with the same studentId.
     * @param student
     * @return true on success and false otherwise
     */
    public boolean add(Student student) {
        boolean tmp = false;
        for (Student x : students) {
            tmp = x.getStudentId() == student.getStudentId(); // if tmp is true, the student already exists
            if (tmp) { break; }
        }
        if (!tmp) { students.add(student); }
        return !tmp;
    }

    /**
     * removes the student with the studentId of student from the list.
     * @param student
     * @return true if an entry was deleted and false otherwise
     */
    public boolean remove(Student student) {
        for (Student x : students) {
            if (x.getStudentId() == student.getStudentId()) {
                int tmp = this.students.indexOf(x);
                this.students.remove(tmp);
                return true;
            }
        }
        return false;
    }

    /**
     * removes the student at position pos from the list.
     * @param pos
     * @return the corresponding student if an entry was deleted and null in case pos is too small / big
     */
    public Student remove(int pos) {
        try {
            Student tmpStudent = this.students.get(pos);
            this.students.remove(pos);
            return tmpStudent;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Returns the student at position pos or null in case pos is too small / big
     * @param pos
     * @return student or null
     */
    public Student get(int pos) {
        try {
            return this.students.get(pos);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Returns a (possibly empty) list of positions, corresponding to the students in the list whose lastname matches lastname.
     * @param lastname
     * @return (possibly empty) list of positions, corresponding to the students
     */
    public ArrayList<Integer> findLastname(String lastname) {
        ArrayList<Integer> lastnamelist = new ArrayList<Integer>();
        for (Student x : students) {
            if (x.getLastname().equals(lastname)) {
                lastnamelist.add(this.students.indexOf(x));
            }
        }
        return lastnamelist;
    }

    /**
     * Returns a (possibly empty) list of positions, corresponding to the students in the list whose lastname matches firstname.
     * @param firstname
     * @return (possibly empty) list of positions, corresponding to the students
     */
    public ArrayList<Integer> findFirstname(String firstname) {
        ArrayList<Integer> firstnamelist = new ArrayList<Integer>();
        for (Student x : students) {
            if (x.getLastname().equals(firstname)) {
                firstnamelist.add(this.students.indexOf(x));
            }
        }
        return firstnamelist;
    }

    /**
     * Should the list contain a student with studentId studentId, return its position in the list, else return -1
     * @param studentId
     * @return student position in the list, or -1
     */
    public int findStudentId(long studentId) {
        for (Student x : students) {
            if (x.getStudentId() == studentId) {
                return this.students.indexOf(x);
            }
        }
        return -1;
    }

    /**
     * Return the number of students inside the list.
     * @return number of students inside the list
     */
    int size() {
        return this.students.size();
    }

    /**
     * Returns true if the list contains the student with studentId studentId. Otherwise return false
     * @param studentId
     * @return true or false
     */
    private boolean containsId(final long studentId) {
        for (Student x : students) {
            if (x.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the private field students
     * @return this.students
     */
    public ArrayList<Student> getStudentList() {
        return this.students;
    }
}

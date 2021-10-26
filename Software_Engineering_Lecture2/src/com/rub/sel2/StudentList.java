package com.rub.sel2;

import java.util.ArrayList;

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
    public boolean add(Student student) {
        boolean tmp = false;
        for (Student x : students) {
            tmp = x.getStudentId() == student.getStudentId();
            if (tmp) { break; }
        }
        if (!tmp) { students.add(student); }
        return !tmp;
    }

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

    public Student remove(int pos) {
        try {
            Student tmpStudent = this.students.get(pos);
            this.students.remove(pos);
            return tmpStudent;
        } catch (Exception ex) {
            return null;
        }
    }

    public Student get(int pos) {
        try {
            return this.students.get(pos);
        } catch (Exception ex) {
            return null;
        }
    }
}

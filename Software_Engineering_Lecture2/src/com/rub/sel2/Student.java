package com.rub.sel2;
import java.util.Date;

public class Student {
    private String firstname, lastname;
    private long studentId;
    private double weight;
    private Date birthday;

    enum SortKey {
        FIRSTNAME,
        LASTNAME,
        STUDENT_ID,
        WEIGHT,
        BIRTHDAY
    }

    // Constructors
    public Student() {
        this(null, null, 1, 0, new Date(0));
    }

    public Student (String firstname, String lastname, long studentId, double weight, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentId = studentId;
        this.weight = weight;
        this.birthday = birthday;
    }

    // Getter
    public String getFirstname() { return this.firstname; }
    public String getLastname() { return this.lastname; }
    public long getStudentId() { return this.studentId; }
    public double getWeight() { return this.weight; }
    public Date getBirthday() { return this.birthday; }
    public String getName() { return this.firstname + " " + this.lastname; }

    // Setter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

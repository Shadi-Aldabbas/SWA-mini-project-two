package com.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private double GPA;
    private String DOB;

    public Student(Integer id, String firstName, String lastName, double GPA, String DOB) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.GPA = GPA;
        this.DOB = DOB;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(firstName + " " + lastName).append('\'');
        sb.append(", GPA='").append(GPA).append('\'');
        sb.append(", DOB='").append(DOB).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}

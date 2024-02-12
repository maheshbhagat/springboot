package com.maheshbhagat.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student(){

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        System.out.println("Student.getId");
        return id;
    }

    public void setId(int id) {
        System.out.println("Student.setId");
        this.id = id;
    }

    public String getFirstName() {
        System.out.println("Student.getFirstName");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("Student.setFirstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println("Student.getLastName");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("Student.setLastName");
        this.lastName = lastName;
    }

    public String getEmail() {
        System.out.println("Student.getEmail");
        return email;
    }

    public void setEmail(String email) {
        System.out.println("Student.setEmail");
        this.email = email;
    }
}

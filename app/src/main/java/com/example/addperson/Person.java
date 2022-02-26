package com.example.addperson;

import androidx.annotation.NonNull;

import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private String iin;

    public Person(String name, String iin) {
        this.name = name;
        this.iin = iin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIIN(String IIN) {
        this.iin = IIN;
    }

    public String getIIN() {
        return this.iin;
    }

    @NonNull
    @Override
    public String toString() {
        return "Имя: " + name + "\nИИН: " + iin + "\n";
    }
}

class Student extends Person {
    private String gpa;

    public Student(String name, String iin) {
        super(name, iin);
    }

    public void setGPA(String gpa) {
        this.gpa = gpa;
    }

    public String getGPA() {
        return this.gpa;
    }

    @NonNull
    @Override
    public String toString() {
        return "Имя: " + super.getName() + "\nИИН: " + super.getIIN() + "\nGPA: " + gpa + "\n";
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, String iin) {
        super(name, iin);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @NonNull
    @Override
    public String toString() {
        return "Имя: " + super.getName() + "\nИИН: " + super.getIIN() + "\nПредмет: " + subject + "\n";
    }
}
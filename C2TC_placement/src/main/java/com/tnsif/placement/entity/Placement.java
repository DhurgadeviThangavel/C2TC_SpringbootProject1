package com.tnsif.placement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;
    private String role;
    private double packageOffered;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference   // Prevents infinite recursion
    private Student student;

    // Constructors
    public Placement() {}

    public Placement(String companyName, String role, double packageOffered, LocalDate date) {
        this.companyName = companyName;
        this.role = role;
        this.packageOffered = packageOffered;
        this.date = date;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getPackageOffered() { return packageOffered; }
    public void setPackageOffered(double packageOffered) { this.packageOffered = packageOffered; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private ArrayList<TestResult> testResults;
}

package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class TestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private int numberOfQuestions;
    private int complexity;
    private String testContinent;
}

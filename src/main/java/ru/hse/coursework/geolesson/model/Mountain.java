package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String name;
    private double height;
    private double length;
    private String highestPoint;
    private String climate;
    private String resources;
    private String origin;
    private String countries;
}

package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class River {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String name;
    private double length;
    private double width;
    private String riverMouth;
    private String riverSource;
    private String usedFor;
    private String countries;
}

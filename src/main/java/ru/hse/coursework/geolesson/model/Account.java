package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Getter
    @Column(unique = true)
    private String username;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "account")
    private List<TestResult> testResults;
}

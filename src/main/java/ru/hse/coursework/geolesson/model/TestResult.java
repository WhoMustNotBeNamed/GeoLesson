package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class TestResult {
    @EmbeddedId
    private TestResultKey id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId("testInfoId")
    @JoinColumn(name = "test_info_id")
    private TestInfo testInfo;

    private double result;
}

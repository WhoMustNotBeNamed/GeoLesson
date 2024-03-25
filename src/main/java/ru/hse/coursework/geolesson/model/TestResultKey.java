package ru.hse.coursework.geolesson.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResultKey implements Serializable {
    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "test_info_id")
    private UUID testInfoId;

}

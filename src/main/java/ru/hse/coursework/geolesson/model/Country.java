package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Getter
    @Column(unique = true)
    private String name;
    private String continent;
    private String capital;
    private String flag;
    private double square;
    private String formOfGovernment;
    private String currency;
    private double population;
    private String language;
    private String religion;
    private String climate;
    private BigDecimal gdp;
    private BigDecimal gdpPerCapita;
    private String levelOfDevelopment;
    private double unemployment;
    private BigDecimal goldReserves;
    private double inflation;
    private String imports;
    private String exports;
    private String naturalResources;
    private String mineralResources;
    private String waterResources;
    private String recreationalResources;
    private String agriculture;
    private String industry;
    private String transportSystem;
    private double ruralPopulation;
    private double urbanPopulation;
    private double literacyRate;

    @ManyToMany
    @JoinTable(
            name = "country_mountains",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "mountain_id")
    )
    private List<Mountain> mountains;

    @ManyToMany
    @JoinTable(
            name = "country_rivers",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "river_id")
    )
    private List<River> rivers;

    @ManyToMany
    @JoinTable(
            name = "country_seas",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "sea_id")
    )
    private List<Sea> seas;
}

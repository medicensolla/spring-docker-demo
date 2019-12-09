package com.conexia.demoSpringDocker.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "public", name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Integer rentalRate;

    @Column(name = "replacement_cost")
    private BigDecimal price;

    @Column(name = "lenght")
    private Integer lenght;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "fulltext")
    private String fullText;
}

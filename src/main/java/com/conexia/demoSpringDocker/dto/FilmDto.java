package com.conexia.demoSpringDocker.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilmDto {

    private Long id;

    private String title;

    private String description;

    private Integer releaseYear;

    private Integer rentalDuration;

    private Integer rentalRate;

    private BigDecimal price;

    private Integer lenght;

    private String specialFeatures;

    private String fullText;
}

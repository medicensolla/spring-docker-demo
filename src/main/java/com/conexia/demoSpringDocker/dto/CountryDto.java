package com.conexia.demoSpringDocker.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CountryDto {

    private Long id;

    private String country;

    private LocalDateTime last_update;
}

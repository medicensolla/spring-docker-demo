package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.dto.FilmDto;

import java.util.List;

public interface FilmService {

    List<FilmDto> findAll();

    public abstract List<FilmDto> getFilmByTitle(String title);

}

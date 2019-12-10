package com.conexia.demoSpringDocker.controller;

import com.conexia.demoSpringDocker.dto.FilmDto;
import com.conexia.demoSpringDocker.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FilmDto>> getAllTheFilms() {

        return new ResponseEntity<>(this.filmService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/search", params = {"title"})
    public ResponseEntity<List<FilmDto>> getFilmByTitle(@RequestParam final String title) {

        return new ResponseEntity<>(this.filmService.getFilmByTitle(title), HttpStatus.OK);
    }

}

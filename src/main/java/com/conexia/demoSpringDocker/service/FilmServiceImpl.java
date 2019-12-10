package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.converter.FilmToFilmDtoConverter;
import com.conexia.demoSpringDocker.dto.FilmDto;
import com.conexia.demoSpringDocker.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmToFilmDtoConverter filmToFilmDtoConverter;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, FilmToFilmDtoConverter filmToFilmDtoConverter) {
        this.filmRepository = filmRepository;
        this.filmToFilmDtoConverter = filmToFilmDtoConverter;
    }

    @Override
    public List<FilmDto> findAll() {

        List<FilmDto> filmListResponse = this.filmRepository.findAll().stream()
                .map(film -> this.filmToFilmDtoConverter.convert(film)).collect(Collectors.toList());
        return filmListResponse;
    }

    @Override
    public List<FilmDto> getFilmByTitle(final String title) {

        List<FilmDto> filmListResponse = this.filmRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(film -> this.filmToFilmDtoConverter.convert(film)).collect(Collectors.toList());

        if (filmListResponse.isEmpty()) {
            final String message = String.format("Error in Provider information");
            log.error(message);
            return null;
        } else {

            return filmListResponse;
        }

    }
}

package com.conexia.demoSpringDocker.converter;

import com.conexia.demoSpringDocker.domain.Film;
import com.conexia.demoSpringDocker.dto.FilmDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmToFilmDtoConverter implements Converter<Film, FilmDto> {


    @Override
    public FilmDto convert(Film film) {

        FilmDto filmDto = new FilmDto();

        BeanUtils.copyProperties(film, filmDto);

        return filmDto;
    }
}

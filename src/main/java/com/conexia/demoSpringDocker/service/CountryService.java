package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.domain.Country;
import com.conexia.demoSpringDocker.dto.CountryDto;

import java.util.List;

public interface CountryService {

    public List<CountryDto> getAllCountries();

    public abstract CountryDto searchById(long id);


}

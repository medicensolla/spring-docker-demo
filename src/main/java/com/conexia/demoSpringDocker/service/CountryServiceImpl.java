package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.converter.CountryToCountryDTOConverter;
import com.conexia.demoSpringDocker.domain.Country;
import com.conexia.demoSpringDocker.dto.CountryDto;
import com.conexia.demoSpringDocker.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final CountryToCountryDTOConverter converter;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryToCountryDTOConverter converter) {
        this.countryRepository = countryRepository;
        this.converter = converter;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        List<CountryDto> countryListResponse = this.countryRepository.findAll().stream().map(
                country -> this.converter.convert(country)).collect(Collectors.toList());

        return countryListResponse;
    }

    @Override
    public CountryDto searchById(long id) {

        CountryDto countryDto = new CountryDto();

        Country country = new Country();

        country = this.countryRepository.findById(id);

        if (Objects.nonNull(country)) {

            countryDto = converter.convert(country);

        }

        return countryDto;
    }
}

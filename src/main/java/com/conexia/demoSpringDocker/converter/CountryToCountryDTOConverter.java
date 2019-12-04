package com.conexia.demoSpringDocker.converter;

import com.conexia.demoSpringDocker.domain.Country;
import com.conexia.demoSpringDocker.dto.CountryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryToCountryDTOConverter implements Converter<Country, CountryDto> {


    @Override
    public CountryDto convert(Country country) {

        CountryDto countryDto = new CountryDto();
        BeanUtils.copyProperties(country,countryDto);
        return countryDto;
    }
}

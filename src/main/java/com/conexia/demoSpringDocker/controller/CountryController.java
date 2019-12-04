package com.conexia.demoSpringDocker.controller;

import com.conexia.demoSpringDocker.dto.CountryDto;
import com.conexia.demoSpringDocker.service.CountryService;
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
@RequestMapping(value = "/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/all")
    public List<CountryDto> getAllCountries() {

        return this.countryService.getAllCountries();
    }

    @GetMapping(value = "/search",
            produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    public ResponseEntity<CountryDto> findById(@RequestParam final long id) {

        return new ResponseEntity<>(this.countryService.searchById(id), HttpStatus.OK);
    }

}

package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.converter.StoreToStoreDTOConverter;
import com.conexia.demoSpringDocker.dto.StoreDto;
import com.conexia.demoSpringDocker.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreToStoreDTOConverter converter;


    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, StoreToStoreDTOConverter converter) {
        this.storeRepository = storeRepository;
        this.converter = converter;
    }

    @Override
    public List<StoreDto> findAll() {

        List<StoreDto> storeListResponse = this.storeRepository.findAll().stream()
                .map(store -> this.converter.convert(store)).collect(Collectors.toList());

        return storeListResponse;
    }
}

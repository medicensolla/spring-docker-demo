package com.conexia.demoSpringDocker.converter;

import com.conexia.demoSpringDocker.domain.Store;
import com.conexia.demoSpringDocker.dto.StoreDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StoreToStoreDTOConverter implements Converter<Store, StoreDto> {
    @Override
    public StoreDto convert(Store store) {

        StoreDto storeDto = new StoreDto();

        BeanUtils.copyProperties(store, storeDto);

        return storeDto;
    }
}

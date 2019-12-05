package com.conexia.demoSpringDocker.converter;

import com.conexia.demoSpringDocker.domain.Actor;
import com.conexia.demoSpringDocker.dto.ActorDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActorToActorDTOConverter implements Converter<Actor, ActorDto> {


    @Override
    public ActorDto convert(Actor actor) {

        ActorDto actorDto = new ActorDto();

        BeanUtils.copyProperties(actor, actorDto);

        return actorDto;
    }
}

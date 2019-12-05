package com.conexia.demoSpringDocker.converter;

import com.conexia.demoSpringDocker.domain.Actor;
import com.conexia.demoSpringDocker.dto.ActorDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActorDTOToActorConverter implements Converter<ActorDto, Actor> {


    @Override
    public Actor convert(ActorDto actorDto) {
        Actor actor = new Actor();

        BeanUtils.copyProperties(actorDto, actor);

        return actor;
    }
}

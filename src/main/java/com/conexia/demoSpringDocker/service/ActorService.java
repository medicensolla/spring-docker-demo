package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.dto.ActorDto;

import java.util.List;

public interface ActorService {

    public abstract ActorDto createActor(ActorDto actorDto);

    public List<ActorDto> findAllActors();

}

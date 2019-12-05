package com.conexia.demoSpringDocker.service;

import com.conexia.demoSpringDocker.converter.ActorDTOToActorConverter;
import com.conexia.demoSpringDocker.converter.ActorToActorDTOConverter;
import com.conexia.demoSpringDocker.domain.Actor;
import com.conexia.demoSpringDocker.dto.ActorDto;
import com.conexia.demoSpringDocker.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    private final ActorToActorDTOConverter actorToActorDTOConverter;

    private final ActorDTOToActorConverter actorDTOToActorConverter;


    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ActorToActorDTOConverter actorToActorDTOConverter, ActorDTOToActorConverter actorDTOToActorConverter) {
        this.actorRepository = actorRepository;
        this.actorToActorDTOConverter = actorToActorDTOConverter;
        this.actorDTOToActorConverter = actorDTOToActorConverter;
    }

    @Override
    public ActorDto createActor(ActorDto actorDto) {

        ActorDto actorResponseDto = new ActorDto();
        Actor newActor = this.actorDTOToActorConverter.convert(actorDto);
        Actor actorResponse = this.actorRepository.save(newActor);
        actorResponseDto = this.actorToActorDTOConverter.convert(actorResponse);

        return actorResponseDto;
    }

    @Override
    public List<ActorDto> findAllActors() {

        List<ActorDto> actorListResponse = this.actorRepository.findAll().stream()
                .map(actor -> this.actorToActorDTOConverter.convert(actor))
                .collect(Collectors.toList());

        return actorListResponse;
    }
}

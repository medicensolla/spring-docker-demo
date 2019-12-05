package com.conexia.demoSpringDocker.controller;

import com.conexia.demoSpringDocker.dto.ActorDto;
import com.conexia.demoSpringDocker.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @PostMapping("/create")
    public ResponseEntity<ActorDto> createActor(@RequestBody ActorDto actorDto) {

        ActorDto actorResponseDto = this.actorService.createActor(actorDto);

        return new ResponseEntity<>(actorResponseDto, HttpStatus.OK);

    }


    @GetMapping("/")
    public List<ActorDto> getAllActors() {
        return this.actorService.findAllActors();
    }
}

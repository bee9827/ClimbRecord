package Climbing.Record.controller;

import Climbing.Record.repository.GymRepository;
import Climbing.Record.service.dto.GymRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GymController {
    private final GymRepository gymRepository;


    @PostMapping("api/gym")
    public void createGym(@RequestBody GymRequestDto gymRequestDto){

    }
}

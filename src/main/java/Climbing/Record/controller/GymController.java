package Climbing.Record.controller;

import Climbing.Record.domain.Gym;
import Climbing.Record.repository.GymRepository;
import Climbing.Record.service.GymService;
import Climbing.Record.service.dto.DifficultyRequestDto;
import Climbing.Record.service.dto.GymRequestDto;
import Climbing.Record.service.dto.GymResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;


    @PostMapping("api/gym")
    public ResponseEntity<Void> createGym(@RequestBody GymRequestDto gymRequestDto){
        gymService.createGym(gymRequestDto);
        return ResponseEntity.ok(  ).build();
    }

    @DeleteMapping("api/gym/{id}")
    public ResponseEntity<Void> deleteGym(@PathVariable Integer id){
        gymService.deleteGym(id);
        return ResponseEntity.ok(  ).build();
    }
    @GetMapping("api/gym")
    public ResponseEntity<List<GymResponseDto>> getGymResponseList(){
        return ResponseEntity.ok(gymService.getResponseDtos());
    }
    @GetMapping("api/gym/{id}")
    public ResponseEntity<Gym> getGym(@PathVariable Integer id){
        return ResponseEntity.ok(gymService.getGym(id));
    }
}

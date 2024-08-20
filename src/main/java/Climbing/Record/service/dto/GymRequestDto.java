package Climbing.Record.service.dto;

import Climbing.Record.domain.Gym;
import lombok.Data;

@Data
public class GymRequestDto {
    private String name;

    public Gym toEntity(){
        return Gym.builder()
                .name(name)
                .build();
    }
}

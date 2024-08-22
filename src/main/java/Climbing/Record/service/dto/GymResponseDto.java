package Climbing.Record.service.dto;

import Climbing.Record.domain.Gym;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymResponseDto {
    private String name;

    public Gym toEntity(){
        return Gym.builder()
                .name(name)
                .build();
    }
    public GymResponseDto(Gym gym){
        name = gym.getName();
    }
}

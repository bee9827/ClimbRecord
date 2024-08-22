package Climbing.Record.service.dto;

import Climbing.Record.domain.Difficulty;
import Climbing.Record.domain.Gym;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GymRequestDto {
    private String name;
    private List<DifficultyRequestDto> difficultyRequestDtos = new ArrayList();

    public Gym toEntity(){
        List<Difficulty> difficulties = difficultyRequestDtos.stream().map(DifficultyRequestDto::toEntity).toList();
        Gym gym = Gym.builder()
                .name(name)
                .build();
        gym.addDifficulties(difficulties);
        return gym;
    }
}

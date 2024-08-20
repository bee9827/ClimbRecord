package Climbing.Record.service;

import Climbing.Record.domain.Difficulty;
import Climbing.Record.domain.Gym;
import Climbing.Record.repository.GymRepository;
import Climbing.Record.service.dto.GymRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GymService {
    private final GymRepository gymRepository;

    public void createGym(GymRequestDto gymRequestDto){
        gymRepository.save(gymRequestDto.toEntity());
    }
    public void deleteGym(Integer gym_id){
        gymRepository.deleteById(gym_id);
    }

    public void addDifficulty(Integer gym_id,Difficulty difficulty){
        gymRepository.findById(gym_id).get().getDifficulties().add(difficulty);
    }
    public void addDifficulties(Integer gym_id,List<Difficulty> difficulties){
        gymRepository.findById(gym_id).get().getDifficulties().addAll(difficulties);
    }
}

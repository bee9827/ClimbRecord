package Climbing.Record.service;

import Climbing.Record.domain.Difficulty;
import Climbing.Record.domain.Gym;
import Climbing.Record.repository.GymRepository;
import Climbing.Record.service.dto.DifficultyRequestDto;
import Climbing.Record.service.dto.GymRequestDto;
import Climbing.Record.service.dto.GymResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GymService {
    private final GymRepository gymRepository;

    public Integer createGym(GymRequestDto gymRequestDto){
        return gymRepository.save(gymRequestDto.toEntity()).getId();
    }
    public void deleteGym(Integer gym_id){
        gymRepository.deleteById(gym_id);
    }
    public List<Gym> getList() {
        return gymRepository.findAll( );
    }
    public List<GymResponseDto> getResponseDtos(){
        return gymRepository.findAll( )
                .stream()
                .map(GymResponseDto::new)
                .toList();
    }
    public Gym getGym(Integer id){
        return gymRepository.findById(id).get();
    }
}

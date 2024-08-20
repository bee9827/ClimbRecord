package Climbing.Record.service;

import Climbing.Record.domain.*;
import Climbing.Record.domain.Record;
import Climbing.Record.repository.GymDifficultyRepository;
import Climbing.Record.repository.GymRepository;
import Climbing.Record.repository.MemberRepository;
import Climbing.Record.repository.RecordRepository;
import Climbing.Record.repository.home.RecordHomeDto;
import Climbing.Record.service.dto.RecordRequestDto;
import jakarta.persistence.Embedded;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class RecordService  {
    private final RecordRepository recordRepository;
    private final MemberRepository memberRepository;
    private final GymRepository gymRepository;
    private final GymDifficultyRepository difficultyRepository;

    public Integer create(Integer member_id,Integer gym_id, Integer difficulty_id ,RecordRequestDto recordRequestDto){
        Record record = recordRequestDto.toEntity();
        record.setGym(gymRepository.findById(gym_id).get());
        record.setDifficulty(difficultyRepository.findById(difficulty_id).get());
        record.setMember(memberRepository.findById(member_id).get());

        return recordRepository.save(record).getId();
    }

    public Map<LocalDate, List<RecordHomeDto>> getHomeRecordList(Integer id, LocalDate localDate){
        return recordRepository.findAllbyIdAndClimbingDate(id,localDate);
    }
    public void delete(Integer record_id){
        recordRepository.deleteById(record_id);
    }


}


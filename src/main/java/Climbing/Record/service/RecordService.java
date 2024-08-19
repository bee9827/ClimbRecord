package Climbing.Record.service;

import Climbing.Record.domain.Record;
import Climbing.Record.repository.RecordRepository;
import Climbing.Record.service.dto.RecordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordService  {
    private final RecordRepository recordRepository;

    public void create(RecordRequestDto recordRequestDto){
        recordRepository.save(recordRequestDto.toEntity());
    }
}

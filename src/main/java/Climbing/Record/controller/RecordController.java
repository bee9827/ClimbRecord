package Climbing.Record.controller;

import Climbing.Record.repository.RecordRepository;
import Climbing.Record.repository.home.RecordHomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordRepository recordRepository;

    @GetMapping("api/records")
    public Map<LocalDate, List<RecordHomeDto>> getRecordHomeList(@RequestParam Integer id,
                                                                 @RequestParam LocalDate localDate){
        return recordRepository.findAllbyIdAndClimbingDate(id,localDate);
    }

}

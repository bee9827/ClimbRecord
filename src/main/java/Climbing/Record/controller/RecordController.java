package Climbing.Record.controller;

import Climbing.Record.repository.home.RecordHomeDto;
import Climbing.Record.service.RecordService;
import Climbing.Record.service.dto.RecordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @PostMapping("api/record")
    public ResponseEntity<Integer> createRecord(@RequestBody RecordRequestDto recordRequestDto){
        return ResponseEntity.ok(recordService.create(recordRequestDto));
    }
    @DeleteMapping("api/record/{record_id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Integer record_id){
        recordService.delete(record_id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("api/member/records")
    public Map<LocalDate, List<RecordHomeDto>> getRecordHomeList(@RequestParam Integer member_id,
                                                                 @RequestParam LocalDate localDate){
        return recordService.getHomeRecordList(member_id,localDate);
    }

}

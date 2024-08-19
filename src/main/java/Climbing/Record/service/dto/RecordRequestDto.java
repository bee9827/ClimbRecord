package Climbing.Record.service.dto;

import Climbing.Record.domain.*;
import Climbing.Record.domain.Record;
import jakarta.persistence.Embedded;

import java.time.LocalDate;

public class RecordRequestDto {
    private Member member;
    private Gym gym;
    private String body;
    private RecordStatus status;
    private LocalDate climbingDate;
    @Embedded
    private ClimbingStatus climbingStatus;

    public Record toEntity(){
        return Record.builder()
                .member(member)
                .gym(gym)
                .body(body)
                .status(status)
                .climbingDate(climbingDate)
                .build();
    }
}

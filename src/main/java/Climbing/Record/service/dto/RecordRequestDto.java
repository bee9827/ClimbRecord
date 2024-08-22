package Climbing.Record.service.dto;

import Climbing.Record.domain.*;
import Climbing.Record.domain.Record;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
public class RecordRequestDto {

    private Integer member_id;
    private Integer gym_id;
    private Integer difficulty_id;
    private String body;
    private RecordStatus status;
    private LocalDate climbingDate;
    @Embedded
    private ClimbingStatus climbingStatus;

    public Record toEntity() {
        return Record.builder( )
                .climbingStatus(climbingStatus)
                .status(status)
                .body(body)
                .climbingDate(climbingDate)
                .build( );
    }
}

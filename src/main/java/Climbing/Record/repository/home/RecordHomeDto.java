package Climbing.Record.repository.home;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordHomeDto {
    private String name;
    private String color;
    private String maximum;
    private LocalDate climbingDate;
}

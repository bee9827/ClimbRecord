package Climbing.Record.repository.home;


import java.time.LocalDate;
import java.util.List;

public interface RecordHomeRepository {
    List<RecordHomeDto> findAllbyIdAndClimbingDate(Integer id, LocalDate localDate);
}

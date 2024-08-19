package Climbing.Record.repository.home;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface RecordHomeRepository {
    Map<LocalDate,List<RecordHomeDto>> findAllbyIdAndClimbingDate(Integer id, LocalDate localDate);
}

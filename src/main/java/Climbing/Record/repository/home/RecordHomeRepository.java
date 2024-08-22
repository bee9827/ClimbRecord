package Climbing.Record.repository.home;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface RecordHomeRepository {
    Map<LocalDate,List<RecordHomeDto>> findAllbyIdAndClimbingDate(Integer id, LocalDate localDate);
}

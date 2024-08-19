package Climbing.Record.repository.home;

import Climbing.Record.domain.QRecord;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecordHomeRepositoryImpl implements RecordHomeRepository {
    private final JPAQueryFactory query;

    @Override
    public List<RecordHomeDto> findAllbyIdAndClimbingDate(Integer id, LocalDate localDate) {
        QRecord record = QRecord.record;
        return query.select(
                Projections.fields(
                        RecordHomeDto.class,
                        record.gym.name,
                        record.difficulty.color,
                        record.difficulty.maximum
                ))
                .from(record)
                .where(record.member.id.eq(id))
                .where(record.climbingDate.eq(localDate))
                .fetch();
    }
}

package Climbing.Record.repository;

import Climbing.Record.domain.Record;
import Climbing.Record.repository.home.RecordHomeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,Integer>, RecordHomeRepository {
}

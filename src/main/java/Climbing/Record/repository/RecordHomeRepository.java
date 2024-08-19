package Climbing.Record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordHomeRepository extends JpaRepository<Record,Integer>, Climbing.Record.repository.home.RecordHomeRepository {
}

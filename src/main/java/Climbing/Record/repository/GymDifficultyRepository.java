package Climbing.Record.repository;

import Climbing.Record.domain.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymDifficultyRepository extends JpaRepository<Difficulty, Integer> {
}

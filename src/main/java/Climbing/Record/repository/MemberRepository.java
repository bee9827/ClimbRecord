package Climbing.Record.repository;

import Climbing.Record.domain.Member;
import Climbing.Record.repository.home.MemberHomeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>, MemberHomeRepository {
}

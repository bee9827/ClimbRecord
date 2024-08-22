package Climbing.Record.repository.home;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberHomeRepository {
    public List<MemberHomeDto> findAllDto(int offset, int limit);

    MemberHomeDto findDtoById(Integer id);
}

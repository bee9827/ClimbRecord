package Climbing.Record.repository.home;

import Climbing.Record.domain.QMember;
import Climbing.Record.domain.QMemberGym;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MemberHomeRepositoryImpl implements MemberHomeRepository {
    private final JPAQueryFactory query;

    @Override
    public List<MemberHomeDto> findAllDto(int offset, int limit) {
        QMember member = QMember.member;

        List<MemberHomeDto> result = query.select(
                Projections.fields(
                        MemberHomeDto.class,
                        member.id.as("memberId"),
                        member.name,
                        member.length,
                        member.armLength,
                        member.startDate
                ))
                .from(member)
                .offset(offset)
                .limit(limit)
                .fetch();

        Map<Integer,List<MemberGymDto>> favorite = findMemberHomeDtos(getMemberIds(result));

        result.forEach(m -> m.setMemberGyms(favorite.get(m.getMemberId())));
        return result;
    }

    @Override
    public MemberHomeDto findDtoById(Integer id) {
        QMember member = QMember.member;
        QMemberGym memberGym = QMemberGym.memberGym;

        MemberHomeDto result =
                query.select(Projections.fields(
                        MemberHomeDto.class,
                        member.id.as("memberId"),
                        member.name,
                        member.length,
                        member.armLength,
                        member.startDate
                ))
                .from(member)
                .where(member.id.eq(id))
                .fetch().get(0);

        List<MemberGymDto> memberGymDtos =
                query.select(Projections.fields(
                        MemberGymDto.class,
                        memberGym.member.id,
                        memberGym.gym.name
                ))
                .from(memberGym)
                .where(memberGym.member.id.eq(id))
                .fetch();

        result.setMemberGyms(memberGymDtos);
        return result;
    }

    public List<Integer> getMemberIds(List<MemberHomeDto> list){
        return list.stream().map(MemberHomeDto::getMemberId).toList();
    }


    public Map<Integer,List<MemberGymDto>> findMemberHomeDtos(List<Integer> memberIds){
        QMemberGym memberGym = QMemberGym.memberGym;

        return query.select( Projections.fields(
                        MemberGymDto.class,
                        memberGym.member.id,
                        memberGym.gym.name))
                .from(memberGym)
                .where(memberGym.member.id.in(memberIds))
                .fetch()
                .stream().collect(Collectors.groupingBy(MemberGymDto::getMemberId));
    }
}

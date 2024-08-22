package Climbing.Record.service;

import Climbing.Record.domain.Member;
import Climbing.Record.domain.Record;
import Climbing.Record.repository.MemberRepository;
import Climbing.Record.service.dto.MemberRequestDto;
import Climbing.Record.repository.home.MemberHomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository ;

    public Integer create(MemberRequestDto memberRequestDto){
        return memberRepository.save(memberRequestDto.toEntity()).getId();
    }
    public void delete(Integer member_id){
        memberRepository.deleteById(member_id);
    }
    public void addRecords(Integer member_id, List<Record> records){
        Member member = memberRepository.findById(member_id).get();
        member.addRecord(records);
    }

    public List<MemberHomeDto> getMemberHomeDtos(int offset, int limit){
        return memberRepository.findAllDto(offset,limit);
    }
    public MemberHomeDto getMemberHomeDto(Integer id){ return memberRepository.findDtoById(id);}

}

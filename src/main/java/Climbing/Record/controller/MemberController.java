package Climbing.Record.controller;

import Climbing.Record.domain.Member;
import Climbing.Record.domain.Record;
import Climbing.Record.repository.MemberRepository;
import Climbing.Record.service.MemberService;
import Climbing.Record.service.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("api/member")
    public ResponseEntity<Integer> createMember(@RequestBody MemberRequestDto memberRequestDto){
        System.out.println( memberRequestDto.getName() );
        return ResponseEntity.ok(memberService.create(memberRequestDto));

    }
    @DeleteMapping("api/member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id){
        memberService.delete(id);
        return ResponseEntity.ok().build();
    }

    // 수정필요 Member 그대로 던지고있음
    @GetMapping("api/member")
    public ResponseEntity<List<Member>> getMemberList(){
        return ResponseEntity.ok(memberRepository.findAll());
    }
    @GetMapping("api/member/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Integer id){
        return ResponseEntity.ok( memberRepository.findById(id).get());
    }

}

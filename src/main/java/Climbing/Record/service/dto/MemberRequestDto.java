package Climbing.Record.service.dto;

import Climbing.Record.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class MemberRequestDto {
    private String name;
    private String introduction;
    private String length;
    private String armLength;
    private LocalDate startDate;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .introduction(introduction)
                .length(length)
                .armLength(armLength)
                .startDate(startDate)
                .build();
    }
}

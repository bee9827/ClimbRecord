package Climbing.Record.repository.home;

import Climbing.Record.domain.MemberGym;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MemberHomeDto {
    private Integer memberId;
    private String name;
    private String length;
    private String armLength;
    private LocalDate startDate;
    private List<MemberGymDto> memberGyms;

}

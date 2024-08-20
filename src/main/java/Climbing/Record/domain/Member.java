package Climbing.Record.domain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Integer id;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList( );

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberGym> memberGyms = new ArrayList( );

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Record> records = new ArrayList( );

    private String name;
    private String introduction;
    private String length;
    private String armLength;
    private LocalDate startDate;

    public void addRecord(List<Record> records){
        this.records.addAll(records);
    }

}
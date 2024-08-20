package Climbing.Record.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    private String body;
    private RecordStatus status;
    private LocalDate climbingDate;
    @Embedded
    private ClimbingStatus climbingStatus;

    @Builder
    public Record(String body, RecordStatus status, LocalDate climbingDate, ClimbingStatus climbingStatus) {
        this.body = body;
        this.status = status;
        this.climbingDate = climbingDate;
        this.climbingStatus = climbingStatus;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}

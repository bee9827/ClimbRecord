package Climbing.Record.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
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
    @JoinColumn(name = "gymDifficulty_id")
    private GymDifficulty difficulty;

    private String body;
    private RecordStatus status;
    private LocalDate climbingDate;
    @Embedded
    private ClimbingStatus climbingStatus;

    @Builder
    public Record(Member member, Gym gym, GymDifficulty difficulty, String body, RecordStatus status, LocalDate climbingDate, ClimbingStatus climbingStatus) {
        this.member = member;
        this.gym = gym;
        this.difficulty = difficulty;
        this.body = body;
        this.status = status;
        this.climbingDate = climbingDate;
        this.climbingStatus = climbingStatus;
    }
}

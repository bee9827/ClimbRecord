package Climbing.Record.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Difficulty {
    @Id
    @GeneratedValue
    @Column(name = "difficulty_id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    private String color;
    private String minimum;
    private String maximum;

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Builder
    public Difficulty(String color, String minimum, String maximum) {
        this.color = color;
        this.minimum = minimum;
        this.maximum = maximum;
    }
}

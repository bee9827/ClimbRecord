package Climbing.Record.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Gym {
    @Id
    @GeneratedValue
    @Column(name = "gym_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private List<Difficulty> difficulties = new ArrayList();

    @OneToMany(mappedBy = "gym",cascade = {CascadeType.ALL})
    private List<Record> records = new ArrayList();

    @Builder
    public Gym(String name) {
        this.name = name;
    }
}

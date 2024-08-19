package domain;

import jakarta.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public class ClimbingStatus {
    private LocalTime takenTime;
    private int tryCount;
    private boolean success;
}

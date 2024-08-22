package Climbing.Record.service.dto;

import Climbing.Record.domain.Difficulty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class DifficultyRequestDto {
    @Valid
    private String color;
    @NotNull
    private String minimum;
    @NotNull
    private String maximum;

    public Difficulty toEntity(){
         return Difficulty.builder()
                .color(color.toString())
                .maximum(maximum)
                .minimum(minimum)
                .build();
    }
}

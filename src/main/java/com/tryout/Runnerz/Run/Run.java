package com.tryout.Runnerz.Run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer kilometers,
        Location location
) {
    public Run(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer kilometers, Location location){
        this.id = id;
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.kilometers = kilometers;
        this.location = location;
        if (!completedOn().isAfter(startedOn())){
            throw new IllegalArgumentException("Completed on must be after started on");
        }
    }
}

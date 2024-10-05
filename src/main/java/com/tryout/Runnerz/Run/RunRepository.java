package com.tryout.Runnerz.Run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

//import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {

    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findRunById(Integer id) {
        for (Run run : runs) {
            if (Objects.equals(run.id(), id)) {
                return Optional.of(run);
            }
        }
        return Optional.empty();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findRunById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now()
                .plusMinutes(30), 6, Location.OUTDOOR));
        runs.add(new Run(2, "Wednesday Morning Run", LocalDateTime.now(), LocalDateTime.now()
                .plusMinutes(25), 5, Location.OUTDOOR));

    }
}

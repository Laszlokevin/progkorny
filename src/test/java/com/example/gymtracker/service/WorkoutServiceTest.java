package com.example.gymtracker.service;

import com.example.gymtracker.model.WorkoutDay;
import com.example.gymtracker.model.Exercise;
import com.example.gymtracker.repository.WorkoutDayRepository;
import com.example.gymtracker.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

class WorkoutServiceTest {

    @Test
    void startWorkout_createsWorkout() {
        WorkoutDayRepository wdRepo = Mockito.mock(WorkoutDayRepository.class);
        ExerciseRepository exRepo = Mockito.mock(ExerciseRepository.class);
        WorkoutService svc = new WorkoutService(wdRepo, exRepo);

        Mockito.when(wdRepo.save(Mockito.any(WorkoutDay.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        WorkoutDay wd = svc.startWorkout("Push");

        assertThat(wd.getType()).isEqualTo("Push");
        assertThat(wd.getDate()).isNotNull();
    }
}

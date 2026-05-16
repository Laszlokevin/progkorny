package com.example.gymtracker.repository;

import com.example.gymtracker.model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {
    Optional<WorkoutDay> findTopByTypeOrderByDateDesc(String type);
}

package com.example.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int repetitions;
    private int intensity;

    @ManyToOne
    @JoinColumn(name = "workout_day_id")
    @JsonBackReference
    private WorkoutDay workoutDay;

    public void setWorkoutDay(WorkoutDay wd) {
        this.workoutDay = wd;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}

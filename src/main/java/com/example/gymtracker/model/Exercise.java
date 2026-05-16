package com.example.gymtracker.model;

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
    private WorkoutDay workoutDay;
}

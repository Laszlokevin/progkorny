package com.example.gymtracker.controller;

import com.example.gymtracker.model.WorkoutDay;
import com.example.gymtracker.model.Exercise;
import com.example.gymtracker.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GymController {

    private final WorkoutService workoutService;

    public GymController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/workouts")
    public WorkoutDay startWorkout(@RequestParam String type) {
        return workoutService.startWorkout(type);
    }

    @GetMapping("/workouts/{id}")
    public Optional<WorkoutDay> getWorkout(@PathVariable Long id) {
        return workoutService.getWorkout(id);
    }

    @GetMapping("/workouts/last/{type}")
    public Optional<WorkoutDay> getLastByType(@PathVariable String type) {
        return workoutService.getLastWorkoutByType(type);
    }

    @PostMapping("/workouts/{id}/exercises")
    public WorkoutDay addExercise(@PathVariable Long id, @RequestBody Exercise ex) {
        return workoutService.addExercise(id, ex);
    }

    @PutMapping("/exercises/{id}")
    public Exercise updateExercise(@PathVariable Long id, @RequestParam int repetitions, @RequestParam int intensity) {
        return workoutService.updateExercise(id, repetitions, intensity);
    }

    @DeleteMapping("/exercises/{id}")
    public void deleteExercise(@PathVariable Long id) {
        workoutService.deleteExercise(id);
    }

    @DeleteMapping("/workouts/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }


    @PutMapping("/workouts/{id}")
    public WorkoutDay updateWorkout(@PathVariable Long id, @RequestParam String type) {
        return workoutService.updateWorkout(id, type);
    }

    @GetMapping("/workouts")
    public List<WorkoutDay> getAll() {
        return workoutService.getAllWorkouts();
    }
}

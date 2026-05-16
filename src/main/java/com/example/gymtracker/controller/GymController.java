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

    // 1. Új edzés indítása
    @PostMapping("/workouts")
    public WorkoutDay startWorkout(@RequestParam String type) {
        return workoutService.startWorkout(type);
    }

    // 2. Edzés lekérdezése ID alapján
    @GetMapping("/workouts/{id}")
    public Optional<WorkoutDay> getWorkout(@PathVariable Long id) {
        return workoutService.getWorkout(id);
    }

    // 3. Utolsó bizonyos típusú edzés visszaadása
    @GetMapping("/workouts/last/{type}")
    public Optional<WorkoutDay> getLastByType(@PathVariable String type) {
        return workoutService.getLastWorkoutByType(type);
    }

    // 4. Gyakorlat hozzáadása edzéshez
    @PostMapping("/workouts/{id}/exercises")
    public WorkoutDay addExercise(@PathVariable Long id, @RequestBody Exercise ex) {
        return workoutService.addExercise(id, ex);
    }

    // 5. Gyakorlat frissítése
    @PutMapping("/exercises/{id}")
    public Exercise updateExercise(@PathVariable Long id, @RequestParam int repetitions, @RequestParam int intensity) {
        return workoutService.updateExercise(id, repetitions, intensity);
    }

    // 6. Gyakorlat törlése
    @DeleteMapping("/exercises/{id}")
    public void deleteExercise(@PathVariable Long id) {
        workoutService.deleteExercise(id);
    }

    // 7. Edzés törlése
    @DeleteMapping("/workouts/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }

    // 8. Edzés típusának változtatása
    @PutMapping("/workouts/{id}")
    public WorkoutDay updateWorkout(@PathVariable Long id, @RequestParam String type) {
        return workoutService.updateWorkout(id, type);
    }

    // 9. Minden edzés lekérdezése
    @GetMapping("/workouts")
    public List<WorkoutDay> getAll() {
        return workoutService.getAllWorkouts();
    }
}

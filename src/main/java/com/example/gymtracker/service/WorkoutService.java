package com.example.gymtracker.service;

import com.example.gymtracker.model.WorkoutDay;
import com.example.gymtracker.model.Exercise;
import com.example.gymtracker.repository.WorkoutDayRepository;
import com.example.gymtracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    private final WorkoutDayRepository workoutDayRepo;
    private final ExerciseRepository exerciseRepo;

    public WorkoutService(WorkoutDayRepository workoutDayRepo, ExerciseRepository exerciseRepo) {
        this.workoutDayRepo = workoutDayRepo;
        this.exerciseRepo = exerciseRepo;
    }

    public WorkoutDay startWorkout(String type) {
        WorkoutDay wd = new WorkoutDay();
        wd.setType(type);
        wd.setDate(LocalDate.now());
        return workoutDayRepo.save(wd);
    }

    public Optional<WorkoutDay> getLastWorkoutByType(String type) {
        return workoutDayRepo.findTopByTypeOrderByDateDesc(type);
    }

    public WorkoutDay addExercise(Long workoutId, Exercise ex) {
        WorkoutDay wd = workoutDayRepo.findById(workoutId)
                .orElseThrow(() -> new IllegalArgumentException("Workout not found"));
        ex.setWorkoutDay(wd);
        exerciseRepo.save(ex);
        wd.getExercises().add(ex);
        return workoutDayRepo.save(wd);
    }

    public void deleteExercise(Long exerciseId) {
        exerciseRepo.deleteById(exerciseId);
    }

    public void deleteWorkout(Long workoutId) {
        workoutDayRepo.deleteById(workoutId);
    }

    public WorkoutDay updateWorkout(Long workoutId, String newType) {
        WorkoutDay wd = workoutDayRepo.findById(workoutId)
                .orElseThrow(() -> new IllegalArgumentException("Workout not found"));
        wd.setType(newType);
        return workoutDayRepo.save(wd);
    }

    public Exercise updateExercise(Long id, int repetitions, int intensity) {
        Exercise exercise = exerciseRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
        exercise.setRepetitions(repetitions);
        exercise.setIntensity(intensity);
        return exerciseRepo.save(exercise);
    }

    public Optional<WorkoutDay> getWorkout(Long id) {
        return workoutDayRepo.findById(id);
    }

    public List<WorkoutDay> getAllWorkouts() {
        return workoutDayRepo.findAll();
    }
}

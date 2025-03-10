package edu.mentorship.helpClasses;

import edu.mentorship.service.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
public final class Sort {
    public static ArrayList<Task> sortTasks(ArrayList<Task> arr) {
        if (arr == null || arr.isEmpty()) {
            return arr;
        }
        arr.sort(Comparator.comparing(task -> {
            if (task.startDate == null) {
                return Long.MAX_VALUE;
            }
            return Math.abs(task.startDate.toEpochDay() - LocalDate.now().toEpochDay());
        }));

        return arr;
    }
}

package edu.mentorship.helpClasses;

import edu.mentorship.service.Task;

import java.util.ArrayList;

import static edu.mentorship.helpClasses.Sort.sortTasks;
public final class PrintTasks {

    public static void printTasks(ArrayList<Task> arr) {
        sortTasks(arr);
        for (Task task : arr) {
            System.out.println(arr.indexOf(task)+".  "+task.toString());
        }
    }
}

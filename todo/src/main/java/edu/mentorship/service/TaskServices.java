package edu.mentorship.service;

import edu.mentorship.helpClasses.DateValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static edu.mentorship.helpClasses.DateValidation.indexValid;
import static edu.mentorship.helpClasses.PrintTasks.printTasks;
public  class TaskServices {
    static ArrayList<Task> tasks = new ArrayList<>();
    static int completed  ;
    static int notCompleted ;
    static int allTasks ;



    public void add(Task task) {
        if (task != null) {
            tasks.add(task);
            System.out.println("\nTask: "+ task.title+" added successfully.");
            allTasks++;
            notCompleted++;
            return;
        }
        System.out.println("\ncan't add task ");
        notCompleted--;
    }

        public void update(int index,String title, String description ,String startDate,String endDate) {
        if(!indexValid(index, tasks))
        {
            System.out.println("can't update task("+index+")");
            return;
        }
        Task existingTask = tasks.get(index);

        if (title != null && !title.isEmpty()) {
            tasks.get(index).setTitle(title);
        }
        if (description != null && !description.isEmpty()) {
            tasks.get(index).setDescription(description);
        }
            if (existingTask.startDate != null) {
                tasks.get(index).setStartDate(startDate);
            }
            if (existingTask.endDate != null) {
                tasks.get(index).setEndtDate(endDate);
            }
        System.out.println("Task at index " + index + " updated successfully.");
    }
    public void delete(int index) {
        if(!indexValid(index, tasks))
        {
            System.out.println("can't remove task("+index+")");
            return;
        }
        // TODO: check for status
        if(!tasks.get(index).status)
            notCompleted--;
        else
            completed--;
        allTasks--;
        tasks.remove(index);
    }
    public void repeat(int index, int times) {
        if (tasks == null || !indexValid(index, tasks)) {
            return;
        }
        long diff;
        diff = Math.abs(tasks.get(index).getEndDate().toEpochDay() - tasks.get(index).getStartDate().toEpochDay());
        LocalDate temp = tasks.get(index).getStartDate();
        if (!tasks.get(index).status) {
            System.out.println(tasks.get(index) + "\tremaining:\t" + diff);
            while (tasks.get(index).getEndDate().isAfter(tasks.get(index).getStartDate())) {
                tasks.get(index).startDate = tasks.get(index).getStartDate().plusDays(times);
                if (tasks.get(index).getStartDate().isAfter(tasks.get(index).getEndDate())) {
                    System.out.println("can't repeat after " + tasks.get(index).getEndDate());
                    tasks.get(index).startDate = temp;
                    return;
                }
                diff = Math.abs(tasks.get(index).getEndDate().toEpochDay() - tasks.get(index).getStartDate().toEpochDay());

                System.out.println(tasks.get(index) + "\tremaining:\t" + diff);
            }
            tasks.get(index).startDate = temp;
        } else {
            System.out.println("task(" + index + ")" + " is completed.");
        }
    }
    public void setComplete(int index) {
        if(!indexValid(index, tasks))
        {
            System.out.println("can't set status for task("+index+")");
            return;
        }
        if(tasks.get(index).status)
        {
            System.out.println("Task("+index +")"+" is already Completed");
            return;
        }
        tasks.get(index).setStatus(true);
        completed = completed+1;
        notCompleted--;
        System.out.println("task("+index+")'s status is Complete." );
    }
    public void print() {
        printTasks(tasks);
    }
    public static int getCompleted() {
        return completed;
    }
    public static int getNotCompleted(){
        return notCompleted;
    }
    public static int getAllTasks() {
        allTasks = tasks.size();
        return allTasks;
    }
    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}


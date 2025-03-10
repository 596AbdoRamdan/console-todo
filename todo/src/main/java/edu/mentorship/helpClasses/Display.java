package edu.mentorship.helpClasses;

import edu.mentorship.service.TaskServices;

import static edu.mentorship.service.TaskServices.*;

public final class Display {
    public static void menu(){
        System.out.println("""
                1.Add Task \
                
                2.Update Task.\
                
                3.Remove Task.\
                
                4.Set Complete\
                
                5.List all the Tasks\
                
                6.Report\

                7.Exit.""");
    }
    public static void taskTypes()
    {
        System.out.println("""
                1.Simple \
                
                2.Recurring \
                
                3.DeadlLine \
                
                """);
    }
    public static float productivityRatio()
    {
        if (getAllTasks() == 0)
            return getCompleted();
        return (float)getCompleted() / getAllTasks();
    }
    public static void report()
    {
        System.out.println("1.Count of completed tasks:\t" + getCompleted() );
        System.out.println("2.Count of uncompleted tasks:\t"+ getNotCompleted());
        System.out.println("3.Productivity ratio:\t" + productivityRatio());
        Count.mostCommon(TaskServices.getTasks());
        System.out.println("4.Top 3 Most Common Task Types.");
        Count.printCommonList();

    }
}

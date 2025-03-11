package edu.mentorship;
import edu.mentorship.helpClasses.DateValidation;
import edu.mentorship.helpClasses.Display;
import edu.mentorship.service.TaskServices;
import edu.mentorship.tasks.DeadLine;
import edu.mentorship.tasks.Recurring;
import edu.mentorship.tasks.Simple;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskServices taskServices = new TaskServices();
        Scanner scanner = new Scanner(System.in);
        int menuChoice,taskType,index;
        boolean startDateAsk;
        String title,description,startDate,endDate;
        System.out.println(" TASK MANAGEMENT SYSTEM (0_0)");
        while (true)
        {
            Display.menu();
            System.out.print("Enter your choice:\t");menuChoice = scanner.nextInt();
            if(menuChoice <=  7)
            {
                switch (menuChoice)
                {
                    // Add Task
                    case 1:
                        System.out.println("**************************************************************************************************************");
                        System.out.println("Task types:");
                        Display.taskTypes();
                        taskType = scanner.nextInt();

                        switch (taskType)
                        {
                            //Simple
                            case 1 :
                                System.out.print("enter task's title :\t");
                                scanner.nextLine();
                                title = scanner.nextLine();
                                System.out.print("enter task's description :\t");
                                description = scanner.nextLine();
                                System.out.print("Do you want add startDate?\t");
                                startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's startDate :\t"); startDate = scanner.nextLine();
                                    taskServices.add(new Simple(title,description,startDate));
                                }
                                else {
                                    taskServices.add(new Simple(title,description));
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                            //Recurring
                            case 2 :
                                System.out.print("enter task's title :\t");
                                scanner.nextLine();
                                title = scanner.nextLine();
                                System.out.print("enter task's descriotion :\t"); description = scanner.nextLine();
                                System.out.print("Do you want add startDate?\t"); startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's startDate :\t"); startDate = scanner.nextLine();
                                    System.out.print("enter task's endDate :\t"); endDate = scanner.nextLine();

                                    taskServices.add(new Recurring(title,description,startDate,endDate));
                                }
                                else {
                                    System.out.print("enter task's endDate :\t"); endDate = scanner.nextLine();
                                    taskServices.add(new Recurring(title,description,endDate));
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                            //DeadLine
                            case 3:
                                System.out.print("enter task's title :\t");
                                scanner.nextLine();
                                title = scanner.nextLine();
                                System.out.print("enter task's descriotion :\t"); description = scanner.nextLine();
                                System.out.print("Do you want add startDate?\t"); startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's startDate :\t"); startDate = scanner.nextLine();
                                    System.out.print("enter task's endDate :\t"); endDate = scanner.nextLine();

                                    taskServices.add(new DeadLine(title,description,startDate,endDate));
                                }
                                else {
                                    System.out.print("enter task's endDate :\t"); endDate = scanner.nextLine();
                                    taskServices.add(new DeadLine(title,description,endDate));
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                        }
                        break;
                    // Update Task
                    case 2:
                        System.out.println("**************************************************************************************************************");
                        System.out.println("Task types:");
                        Display.taskTypes();
                        taskType = scanner.nextInt();
                        System.out.println("enter Task's Index:\t"); index = scanner.nextInt(); scanner.nextLine();
                        if (!DateValidation.indexValid(index, TaskServices.getTasks())) {
                            System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                            break;
                        }
                        switch (taskType)
                        {
                            //Simple
                            case 1 :
                                System.out.print("enter task's newTitle :\t");
                                title = scanner.nextLine();
                                System.out.print("enter task's newDescription :\t");
                                description = scanner.nextLine();
                                System.out.print("Do you want update startDate(true/false)?\t");
                                startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's newStartDate :\t"); startDate = scanner.nextLine();
                                    taskServices.update(index,title,description,startDate," ");
                                }
                                else {
                                    taskServices.update(index,title,description," "," ");
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                            //Recurring
                            case 2 :
                                System.out.print("enter task's newTitle :\t");
                                scanner.nextLine();
                                title = scanner.nextLine();
                                System.out.print("enter task's newDescription :\t");
                                description = scanner.nextLine();
                                System.out.print("Do you want update startDate(true/false)?\t");
                                startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's newStartDate :\t"); startDate = scanner.nextLine();
                                    System.out.print("enter task's newEndDate :\t"); endDate = scanner.nextLine();

                                    taskServices.update(index,title,description,startDate,endDate);
                                }
                                else {
                                    System.out.print("enter task's newEndDate :\t"); endDate = scanner.nextLine();
                                    taskServices.update(index,title,description," "," ");
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                            //DeadLine
                            case 3:
                                System.out.print("enter task's newTitle :\t");
                                scanner.nextLine();
                                title = scanner.nextLine();
                                System.out.print("enter task's newDescription :\t");
                                description = scanner.nextLine();
                                System.out.print("Do you want update startDate(true/false)?\t");
                                startDateAsk = scanner.nextBoolean();
                                scanner.nextLine();
                                if(startDateAsk){
                                    System.out.print("enter task's newStartDate :\t"); startDate = scanner.nextLine();
                                    System.out.print("enter task's newEndDate :\t"); endDate = scanner.nextLine();

                                    taskServices.update(index,title,description,startDate,endDate);
                                }
                                else {
                                    System.out.print("enter task's newEndDate :\t"); endDate = scanner.nextLine();
                                    taskServices.update(index,title,description," "," ");
                                }
                                System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                                break;
                        }
                        break;
                    // Remove Task
                    case 3:
                        System.out.println("**************************************************************************************************************");
                        System.out.println("enter Task's Index:\t"); index = scanner.nextInt(); scanner.nextLine();
                        taskServices.delete(index);
                        System.out.println("\n*****************************************BACK TO MENU******************************************************\n");

                        break;
                    // SetComplete
                    case 4 :
                        System.out.println("**************************************************************************************************************");
                        System.out.println("enter Task's Index:\t"); index = scanner.nextInt(); scanner.nextLine();
                        taskServices.setComplete(index);
                        System.out.println("\n*****************************************BACK TO MENU******************************************************\n");

                        break;
                    // print List
                    case 5:
                        System.out.println("**************************************************************************************************************");
                        System.out.println("\nList:");
                        taskServices.print();
                        System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                        break;
                    // Report
                    case 6:
                        System.out.println("**************************************************************************************************************");
                        Display.report();
                        System.out.println("\n*****************************************BACK TO MENU******************************************************\n");
                        break;
                    case 7:
                        return;
                }
            }else
                System.out.println("choice number must be from menu!!!");
        }
    }
}


package edu.mentorship.service;
import java.time.LocalDate;

public abstract class Task  {
    public  String  title , description;
    public  LocalDate startDate,endDate;
    public  boolean status;

    //setters
    public abstract void setTitle(String title);
    public abstract void setDescription(String description);
    public abstract void setStatus(boolean status);
    public  abstract void setStartDate(String  startDate);
    public abstract void setEndtDate(String date);

    // getters
    public abstract String getTaskType();

    public abstract String getTitle();

    public abstract String getDescription();

    public abstract LocalDate getStartDate();

    public abstract LocalDate getEndDate();

    public abstract boolean getStatus() ;



    @Override
    public String toString() {
        return "TaskType: " +getTaskType()+"\t {" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus()+
                '}';
    }
}

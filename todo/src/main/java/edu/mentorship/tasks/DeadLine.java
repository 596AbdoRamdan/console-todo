package edu.mentorship.tasks;

import edu.mentorship.service.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static edu.mentorship.helpClasses.DateValidation.isValid;

public class DeadLine extends Task {

    // constructor
    public DeadLine( String title,String description,String endDate) {
        startDate = LocalDate.now();
        setDescription(description);
        setTitle(title);
        if(isValid(endDate))
        {
            setEndtDate(endDate);
        }
    }
    public DeadLine( String title,String description,String startDate, String  endDate) {
        setDescription(description);
        setTitle(title);
        setStartDate(startDate);
        setEndtDate(endDate);
    }
    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setEndtDate(String date) {
        if (isValid(date))
        {
            endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }
    public void setStartDate(String  startDate) {
        if (isValid(startDate))
        {
            this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        else
        {
            this.startDate = LocalDate.now();
        }
    }

    //getters
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public  String getTaskType()
    {
        return getClass().getSimpleName();
    }

    public boolean getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return super.toString() +"\tDate: " +"{ StartDate: " + getStartDate() + " \tEndDate: "+getEndDate()+" }";
    }
}

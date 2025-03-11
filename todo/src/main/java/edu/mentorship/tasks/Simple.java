package edu.mentorship.tasks;

import edu.mentorship.service.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static edu.mentorship.helpClasses.DateValidation.isValid;


public class Simple extends Task {

    // constructor
    public Simple(String title, String description)
    {
        setTitle(title);
        setDescription(description);
        startDate = LocalDate.now();
    }
    public Simple(String title, String description,String date) {
        setTitle(title);
        setDescription(description);
        setStartDate(date);
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
            System.out.println("date is notValid start date will be today.");
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
    public boolean getStatus() {
        return status;
    }

    public  String getTaskType()
    {
        return getClass().getSimpleName();
    }
    @Override
    public String toString() {
        return super.toString() + "\tDate: " +  "{ " + getStartDate() + " }";
    }
}

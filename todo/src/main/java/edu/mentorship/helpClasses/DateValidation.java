package edu.mentorship.helpClasses;

import edu.mentorship.service.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
public final class DateValidation {
    static boolean valid = false;
    static LocalDate date;
    public static boolean isValid(String date) {
        try {

            DateValidation.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (!DateValidation.date.isBefore(LocalDate.now())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Date must be today or a future date.");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            System.out.println("Please enter the correct format (yyyy-MM-dd).");
        }
        return valid;
    }
    public static boolean indexValid(int index , ArrayList<Task> arr) {
        if(index < 0 || index >= arr.size() )
        {
            System.out.println("invalid index!");
            return false;
        }
        else {
            return true;
        }
    }
}

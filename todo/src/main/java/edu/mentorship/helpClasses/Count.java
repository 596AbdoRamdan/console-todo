package edu.mentorship.helpClasses;

import edu.mentorship.service.Task;

import java.util.ArrayList;
import java.util.Arrays;

public final class Count {

    static int simple, recurring, deadLine;
    static Object[][] commonList;

    public static Object[][] mostCommon(ArrayList<Task> arr) {
        // Reset counters to avoid accumulating values across multiple calls
        simple = recurring = deadLine = 0;

        // Count task types
        for (Task task : arr) {
            switch (task.getTaskType()) {
                case "Simple" -> simple++;
                case "Recurring" -> recurring++;
                case "DeadLine" -> deadLine++;
            }
        }

        // Update the array dynamically
        commonList = new Object[][]{
                {simple, "SimpleTask"},
                {recurring, "RecurringTask"},
                {deadLine, "DeadLineTask"}
        };

        // Sort by task count in descending order
        Arrays.sort(commonList, (a, b) -> Integer.compare((int) b[0], (int) a[0]));

        return commonList;
    }

    public static void printCommonList() {
        // Check if commonList is initialized
        if (commonList == null) {
            System.out.println("Error: Call mostCommon() before printing!");
            return;
        }

        // Print the sorted task types with counts
        for (Object[] row : commonList) {
            System.out.println(row[1] + " -> " + row[0]);
        }
    }
}

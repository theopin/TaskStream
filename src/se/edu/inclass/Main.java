package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        //System.out.println("Printing deadlines");
        //printDeadlines(tasksData);

        //System.out.println("Total number of deadlines: " + countDeadlines(tasksData));


        printDeadlinesUsingStreams(tasksData);
        System.out.println("Checking for 11");
        for(Task t: filterByString(tasksData, "11")){
            System.out.println(t);
        }


        printDataUsingStreams(tasksData);

        printDeadlinesUsingStreams(tasksData);
        System.out.println("Total number of deadlines: " + countDeadlinesUsingStreams(tasksData));
        //countDeadlinesUsingStreams(tasksData);

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Print data using stream");
        tasksData.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingStreams(ArrayList<Task> tasksData) {

        tasksData.stream()
                .filter((s) -> s instanceof Deadline)
                .sorted((a, b) -> a.getDescription().toLowerCase().compareTo(b.getDescription().toLowerCase()))
                .forEach(System.out::println);
    }

    public static ArrayList<Task> filterByString(ArrayList<Task> tasksData, String filerString) {
        ArrayList<Task> filteredTaskList;
        filteredTaskList = (ArrayList<Task>) tasksData.stream()
                .filter((s) -> s.getDescription().contains(filerString))
                .collect(toList());

        return filteredTaskList;
    }
}

        System.out.println("Print deadlines using stream");
        tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);

    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Calculate count - deadlines using stream");
        int count = 0;
        count = (int) tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count;
    }

}

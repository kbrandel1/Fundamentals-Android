package project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;

class Individuals {

    String taskName, taskDescription;
    int priorityLevel;

    public Individuals(String taskName, String taskDescription, int priorityLevel) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priorityLevel = priorityLevel;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

}

class Tasks implements Iterable<Individuals> {
    private List<Individuals> individuals = new ArrayList<>();

    public void add(String name, String description, int priority) {
        Individuals newTask = new Individuals(name, description, priority);
        individuals.add(newTask);
    }

    public void remove(int index) {
        individuals.remove(index);
    }

    public void update(int index, String name, String description, int priority) {
        remove(index);
        add(name, description, priority);
    }

    @Override
    public Iterator<Individuals> iterator() {
        return individuals.iterator();
    }

    public void getPriority(int priority) {

        for (Individuals i : individuals) {
            if (i.priorityLevel == priority) {
                System.out.println(i.taskName + "" + i.taskDescription + "" + i.priorityLevel);
            }
        }
    }

    public void toExit() {
        //Environment.Exit(0);
    }
}

class TaskList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean keepGoing = true;
        Tasks tasks = new Tasks();

        while (keepGoing) {
            boolean isInt = false;
            System.out.println
                    ("Please choose an option:	\n" +
                            "(1) Add a task		        \n" +
                            "(2) Remove a task	        \n" +
                            "(3) Update a task	        \n" +
                            "(4) List all tasks	        \n" +
                            "(5) List all tasks of a certain Priority \n " +
                            "(0) Exit");
            String inputString = sc.nextLine();
            while (!isInt) {
                try {
                    input = Integer.parseInt(inputString);
                    isInt = true;
                    if ((input > 5) || (input < 0)) {
                        isInt = false;
                    }
                } catch (NumberFormatException ii) {
                    System.out.println(inputString + " needs to be an integer between 0 and 5" + ii);
                }
            }
            switch (input) {
                case 1:
                    System.out.println("Enter the new task's name.");
                    String taskName = sc.nextLine();
                    System.out.println("Enter a description of the new task.");
                    String taskDescription = sc.nextLine();
                    System.out.println("Enter the task's priority");
                    String priorityLevel = sc.nextLine();
                    int priority = 0;
                    isInt = false;
                    while (!isInt) {
                        try {

                            priority = Integer.parseInt(priorityLevel);
                            isInt = true;
                        } catch (Exception eee) {
                            System.out.println(priorityLevel + " needs to be an integer");
                        }
                    }
                    tasks.add(taskName, taskDescription, priority);
                    break;

                case 2:
                    System.out.println("Enter the index of the task to update.");
                    String inputRemove = sc.nextLine();
                    int remove = 0;
                    isInt = false;
                    while (!isInt) {
                        try {
                            remove = Integer.parseInt(inputRemove);
                            isInt = true;
                        } catch (Exception iii) {
                            System.out.println(inputRemove + " needs to be an integer");
                        }
                    }
                    tasks.remove(remove);
                    break;

                case 3:
                    System.out.println("Enter the index of the task to update.");
                    String inputUpdate = sc.nextLine();
                    int update = 0;
                    isInt = false;
                    while (!isInt) {
                        try {
                            update = Integer.parseInt(inputUpdate);
                            isInt = true;
                        } catch (Exception i) {
                            System.out.println(inputUpdate + " needs to be an integer");
                        }
                    }
                    tasks.remove(update);
                    System.out.println("Enter the new task's name.");
                    taskName = sc.nextLine();
                    System.out.println("Enter a description of the new task.");
                    taskDescription = sc.nextLine();
                    System.out.println("Enter the task's priority");
                    priorityLevel = sc.nextLine();
                    priority = 0;
                    isInt = false;
                    while (!isInt) {
                        try {

                            priority = Integer.parseInt(priorityLevel);
                            isInt = true;
                        } catch (Exception e) {
                            System.out.println(priorityLevel + " needs to be an integer");
                        }

                    }

                    tasks.add(taskName, taskDescription, priority);
                    break;

                case 4:
                    for (Individuals i : tasks) {
                        System.out.println(i.taskName + " " + i.taskDescription + " " + i.priorityLevel);
                    }
                    break;


                case 5:
                    System.out.println("Enter the task's priority");
                    priorityLevel = sc.nextLine();
                    priority = 0;
                    isInt = false;
                    while (!isInt) {
                        try {

                            priority = Integer.parseInt(priorityLevel);
                            isInt = true;
                        } catch (Exception e) {
                            System.out.println(priorityLevel + " needs to be an integer");
                        }

                    }
                    tasks.getPriority(priority);
                    break;


                case 6:
                    keepGoing = false;
                    break;
            }
        }
    }
}



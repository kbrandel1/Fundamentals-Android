package project2;

//import com.sun.org.apache.xpath.internal.SourceTree;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taskList {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> tasks = new ArrayList<>();



    public static void main(String[] args) {
        String input = "";

        try {
            System.out.println
                    ("Please choose an option:	\n" +
                            "(1) Add a task		        \n" +
                            "(2) Remove a task	        \n" +
                            "(3) Update a task	        \n" +
                            "(4) List all tasks	        \n" +
                            "(5) List all tasks of a certain Priority \n " +
                            "(0) Exit");

            input = sc.nextLine();
        } catch (NumberFormatException ii) {
            System.out.println(input + " needs to be an integer between 0 and 5" + ii);
        }

        while (Integer.parseInt(input) != 0) {
            switch (input) {
                case "1":
                    Individuals.getAdd();
                    break;

                case "2":
                    Individuals.getRemove();
                    break;

                case "3":
                    Individuals.getUpdate();
                    break;

                case "4":
                    Individuals.getList(tasks);
                    break;

                case "5":
                    Individuals.getPriority(tasks);
                    break;

                case "6":
                    Individuals.toExit();
                    break;
            }

            try {
                System.out.println
                        ("Please choose an option:	\n" +
                                "(1) Add a task		        \n" +
                                "(2) Remove a task	        \n" +
                                "(3) Update a task	        \n" +
                                "(4) List all tasks	        \n" +
                                "(5) List all tasks of a certain Priority \n " +
                                "(0) Exit");

                input = sc.nextLine();
            } catch (NumberFormatException eee) {
                System.out.println(input + " needs to be an integer between 0 and 5");
            }
        }

    }
}
class Individuals extends taskList {
    static String addTask,taskName,setPriority,inputRemove,input;
    static int inputUpdate;

    taskList task = new taskList();

    public static void getAdd() {


        System.out.println("Enter the new task's name.");
        taskName = sc.nextLine();
        tasks.add(taskName);
        System.out.println("Enter a description of the new task.");
        addTask = sc.nextLine();
        tasks.add(addTask);
        try
        {
        System.out.println("Enter the task's priority");
        setPriority = sc.nextLine();
        tasks.add(setPriority);
        }
        catch (NumberFormatException ee)
        {
            System.out.println(setPriority + " needs to be an integer");
        }

    }

    public static void getRemove() {

            System.out.println("Enter the index of the task to update.");
            inputRemove = sc.nextLine();
            tasks.remove(Integer.parseInt(inputRemove));
    }

    public static void getUpdate() {
        try {
            System.out.println("Enter the index of the task to update.");
            inputUpdate = sc.nextInt();
            tasks.remove(inputUpdate);
            getAdd();
        }
        catch  (NumberFormatException ie) {
            System.out.println(inputUpdate + " needs to be an integer");
        }
    }


    public static void getList(List<String> tasks) {
        //String displayList = sc.nextLine();
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    public static void getPriority(List<String> tasks) {

        System.out.println("Enter a priority");
        input = sc.nextLine();
        for (String priority : tasks) {
            if (input.equals(setPriority)) {
                System.out.println(priority);
            }
        }


    }
    public static void toExit() {
        //System.out.println();
    }


}






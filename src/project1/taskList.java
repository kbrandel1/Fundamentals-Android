package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taskList
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> tasks = new ArrayList<>();
    public static void main(String[] args) {
        String input;

        System.out.println
                ("Please choose an option:	\n" +
                        "(1) Add a task		        \n" +
                        "(2) Remove a task	        \n" +
                        "(3) Update a task	        \n" +
                        "(4) List all tasks	        \n" +
                        "(0) Exit" );

        input = sc.nextLine();

        while (Integer.parseInt(input) != 0) {
            switch (input) {
                case "1":
                    getAdd();
                    break;

                case "2":
                    getRemove();
                    break;

                case "3":
                    getUpdate();
                    break;

                case "4":
                    getList(tasks);
                    break;

                case "5":
                    toExit();
                    break;
            }


            System.out.println
                    ("Please choose an option:	\n" +
                            "(1) Add a task		        \n" +
                            "(2) Remove a task	        \n" +
                            "(3) Update a task	        \n" +
                            "(4) List all tasks	        \n" +
                            "(0) Exit" );

            input = sc.nextLine();
        }
    }




    static void getAdd()
    {
        String addTask;

        System.out.println("Enter a description of the task.");
        addTask = sc.nextLine();
        tasks.add(addTask);

    }

    public static void getRemove()
    {
        String inputRemove;
        System.out.println("Enter the index of the task to update.");
        inputRemove = sc.nextLine();
        tasks.remove(Integer.parseInt(inputRemove));
    }

    public static void getUpdate()
    {
        String updateTask;
        int inputUpdate;
        System.out.println("Enter the index of the task to update.");
        inputUpdate = sc.nextInt();
        tasks.remove(inputUpdate);
        System.out.println("Enter the new description of the task.");
        updateTask = sc.nextLine();
        tasks.add(updateTask);
    }
    public static void getList(List<String> tasks)
    {
        //String displayList = sc.nextLine();
        for(String task: tasks)
        {
            System.out.println(task);
        }
    }
    public static void toExit()
    {
        //System.out.println();
    }




}

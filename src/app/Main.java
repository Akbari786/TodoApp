package app;

import model.Task;
import service.TaskManager;
import service.CSVHandler;

import java.util.Scanner;

/**
 * Hauptklasse Main - Einstiegspunkt der Anwendung.
 * Main class - entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        CSVHandler csvHandler = new CSVHandler("tasks.csv");

        // Aufgaben aus Datei laden / Load tasks from file
        csvHandler.loadTasks(manager);

        while (true) {
            System.out.println("\n===== TO-DO APP =====");
            System.out.println("1. Neue Aufgabe hinzufügen / Add new task");
            System.out.println("2. Aufgaben anzeigen / Show tasks");
            System.out.println("3. Aufgabe erledigt markieren / Mark task as done");
            System.out.println("4. Beenden / Exit");
            System.out.print("Eingabe / Input: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Aufgabe eingeben / Enter task: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    csvHandler.saveTasks(manager.getTasks());
                    break;
                case "2":
                    System.out.println("\n--- Aufgaben / Tasks ---");
                    int i = 0;
                    for (Task t : manager.getTasks()) {
                        System.out.println((i++) + ": " + t);
                    }
                    break;
                case "3":
                    System.out.print("Index der Aufgabe / Task index: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    manager.markTaskDone(index);
                    csvHandler.saveTasks(manager.getTasks());
                    break;
                case "4":
                    System.out.println("Programm beendet. / Program exited.");
                    csvHandler.saveTasks(manager.getTasks());
                    return;
                default:
                    System.out.println("Ungültige Eingabe! / Invalid input!");
            }
        }
    }
}


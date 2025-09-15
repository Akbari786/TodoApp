package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse TaskManager - verwaltet alle Aufgaben.
 * Class TaskManager - manages all tasks.
 */
public class TaskManager {
    private List<Task> tasks;

    // Konstruktor / Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Neue Aufgabe hinzufügen / Add new task
    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    // Aufgabe als erledigt markieren / Mark task as done
    public void markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        }
    }

    // Liste aller Aufgaben zurückgeben / Return list of all tasks
    public List<Task> getTasks() {
        return tasks;
    }

    // Alle Aufgaben löschen / Clear all tasks
    public void clearTasks() {
        tasks.clear();
    }
}

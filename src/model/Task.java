package model;

/**
 * Klasse Task - repräsentiert eine einzelne Aufgabe.
 * Class Task - represents a single to-do item.
 */
public class Task {
    private String description; // Beschreibung / Description
    private boolean done;       // Status (erledigt oder nicht) / Status (done or not)

    // Konstruktor / Constructor
    public Task(String description) {
        this.description = description;
        this.done = false; // Standardwert: nicht erledigt / Default: not done
    }

    // Getter für Beschreibung / Getter for description
    public String getDescription() {
        return description;
    }

    // Setter für Beschreibung / Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Prüfen, ob erledigt / Check if done
    public boolean isDone() {
        return done;
    }

    // Aufgabe als erledigt markieren / Mark task as done
    public void markDone() {
        this.done = true;
    }

    // CSV-Format zurückgeben / Return CSV format
    public String toCSV() {
        return description + "," + done;
    }

    // Aus CSV-Zeile Task erstellen / Create task from CSV line
    public static Task fromCSV(String line) {
        String[] parts = line.split(",");
        Task task = new Task(parts[0]);
        if (parts.length > 1 && Boolean.parseBoolean(parts[1])) {
            task.markDone();
        }
        return task;
    }

    // String-Darstellung / String representation
    @Override
    public String toString() {
        return (done ? "[x] " : "[ ] ") + description;
    }
}

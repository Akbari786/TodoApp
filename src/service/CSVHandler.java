package service;


import model.Task;
import java.io.*;
import java.util.List;

/**
 * Klasse CSVHandler - speichert und lädt Aufgaben in/aus CSV.
 * Class CSVHandler - saves and loads tasks from CSV.
 */
public class CSVHandler {
    private String fileName;

    // Konstruktor / Constructor
    public CSVHandler(String fileName) {
        this.fileName = fileName;
    }

    // Aufgaben in CSV speichern / Save tasks to CSV
    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.write(task.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern! / Error while saving: " + e.getMessage());
        }
    }

    // Aufgaben aus CSV laden / Load tasks from CSV
    public void loadTasks(TaskManager manager) {
        File file = new File(fileName);
        if (!file.exists()) return; // Keine Datei vorhanden / No file exists yet

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Task.fromCSV(line);
                manager.getTasks().add(task);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden! / Error while loading: " + e.getMessage());
        }
    }
}

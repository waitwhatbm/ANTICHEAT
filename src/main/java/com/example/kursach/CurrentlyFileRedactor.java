package com.example.kursach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentlyFileRedactor {
    public static void saveTextToFile(String fileName, String text) {
        try {
            // Create the directory if it doesn't exist
            Path dirPath = Paths.get(Handler.getPathToDB());
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // Write the text to the file
            Path filePath = dirPath.resolve(fileName);
            Files.write(filePath, text.getBytes());

            System.out.println("File saved successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
    public static void writeToFile(String filePath, String content) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Записываем содержимое в файл
            writer.write(content);
            System.out.println("Содержимое успешно записано в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
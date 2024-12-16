package com.example.kursach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;
public class Handler {
    public static int[] results = new int[2];
    public static int count = 0;
    public static int NumberOfFiles = 0;
    public static boolean FileCount = true;
    public static int HandleFunc() {
        String inputFilePath = Handler.getPathToFile(); // Укажите путь к файлу с исходным кодом
        String databaseDirectoryPath = Handler.getPathToDB(); // Укажите путь к директории с файлами базы данных


        try {
            // Чтение файла с исходным кодом
            String inputCode = FileReaderUtil.readFile(inputFilePath);

            // Подсчет вхождений слов в файлах базы данных

            Files.list(Paths.get(databaseDirectoryPath))
                    .filter(Files::isRegularFile) // Фильтруем только текстовые файлы
                    .forEach(filePath -> {
                        try {
                            Handler.FileCounter();
                            List<String> lines = Files.readAllLines(filePath);
                            int result = Analyzer.nGrams(FileReaderUtil.removeSymbols(concatenateStrings(lines)),FileReaderUtil.removeSymbols(inputCode));
                            //System.out.println(inputCode);

                            Handler.AddToArray(result);

                        } catch (IOException e) {
                            System.err.println("Ошибка при чтении файла " + filePath + ": " + e.getMessage());
                        }
                    });
            Handler.FileCount = false;
            if (findMaxElement(Handler.results, Handler.count) == -1) {
                return 0;
            } else {
                int RES = findMaxElement(Handler.results, Handler.count);
                ArrayUtilization();
                return RES;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void FileCounter() {
        if (Handler.FileCount) {
            Handler.NumberOfFiles += 1;
        }
    }
    public static int GetFileCounter() {
        Handler.NumberOfFiles += 1;
        return Handler.NumberOfFiles;
    }
    public static void ArrayUtilization() {
        int[] newNumbers = new int[2]; // Увеличиваем размер в 2 раза
        Handler.results = newNumbers; // Перенаправляем ссылку на новый массив
        Handler.count = 0;
    }
    public static void AddToArray(int result) {
        Handler.results[count] = result;
        Handler.count+=1;
        if (Handler.count == Handler.results.length) {
            int[] newNumbers = new int[Handler.results.length * 2]; // Увеличиваем размер в 2 раза
            System.arraycopy(Handler.results, 0, newNumbers, 0, Handler.results.length); // Копируем старые значения
            Handler.results = newNumbers; // Перенаправляем ссылку на новый массив
        }
    }

    public static String getPathToFile() {
        return "D:\\test.txt";
    }
    public static String getPathToDB() {
        return "D:\\JavaDataBase";
    }

    public static String concatenateStrings(List<String> strings) {
        StringBuilder result = new StringBuilder(); // Используем StringBuilder для эффективной конкатенации
        for (String str : strings) {
            result.append(str); // Добавляем каждую строку к результату
        }
        return result.toString(); // Преобразуем StringBuilder в строку и возвращаем
    }
    public static int findMaxElement(int[] array, int count) {
        int max = array[0]; // Начальное значение максимального элемента
        for (int i = 1; i < count; i++) {
            if (array[i] > max) {
                max = array[i]; // Обновляем максимальный элемент
            }
        }
        return max;
    }
}
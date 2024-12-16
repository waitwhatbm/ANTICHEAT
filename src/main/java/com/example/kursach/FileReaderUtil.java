package com.example.kursach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class FileReaderUtil {
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public static String removeSymbols(String code) {
        StringBuilder res = new StringBuilder();
        String correctSymbols = "+=-/&|!<>(){}*`[]%";
        char[] r = code.toCharArray();
        boolean flag1 = true;
        boolean flag2 = true;

        for (char val : r) {
            String symbol = String.valueOf(val);
            if (symbol.equals("'")) {
                flag1 = flagChange(flag1);
            }
            if (symbol.equals("\"")) {
                flag2 = flagChange(flag2);
            }
            if (flag1 && flag2 && correctSymbols.contains(symbol)) {
                res.append(symbol);
            }
        }
        System.out.println(res.toString());
        return res.toString();
    }

    private static boolean flagChange(boolean flag) {
        return !flag; // Переключение значения флага
    }
}
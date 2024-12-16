package com.example.kursach;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class Analyzer {

    public static int nGrams(String firstCode, String secondCode) {
        System.out.println();
        System.out.println("N_gramms");
        int res = 0;
        int interimResult = 0;
        double maxVolume;

        // Приведение строк к максимальной длине
        String[] maxLenResult = maxLen(firstCode, secondCode);
        firstCode = maxLenResult[0];
        secondCode = maxLenResult[1];

        if (firstCode.length() < 4 || secondCode.length() < 4) {
            System.out.println("NO SOLVE");
            return -1;
        }
        if ((double) firstCode.length() / secondCode.length() <= 0.6) {
            System.out.println("NO SOLVE");
            return -1;
        }
        if ((double) secondCode.length() / firstCode.length() <= 0.6) {
            System.out.println("NO SOLVE");
            return -1;
        }

        char[] first = firstCode.toCharArray();
        maxVolume = secondCode.length() - 2;

        for (int i = 2; i < first.length; i++) {
            StringBuilder resStr = new StringBuilder();
            for (int j = i - 2; j <= i; j++) {
                resStr.append(first[j]);
            }
            System.out.print(resStr.toString() + "        ");
            if (secondCode.contains(resStr)) {
                interimResult++;
            }
        }
        System.out.println();
        System.out.println("max: " + maxVolume + "  interim: " + interimResult);
        res = (int) ((interimResult * 100) / maxVolume);
        System.out.println("lens: " + firstCode.length() + " " + secondCode.length());
        System.out.println(firstCode + "     " + secondCode);
        System.out.println("N_GRAMMS: " + res);
        return res;
    }

    private static String[] maxLen(String firstCode, String secondCode) {
        if (firstCode.length() < secondCode.length()) {
            return new String[]{firstCode, secondCode};
        }
        return new String[]{secondCode, firstCode};
    }

}
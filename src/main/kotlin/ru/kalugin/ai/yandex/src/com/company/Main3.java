package ru.kalugin.ai.yandex.src.com.company;

import java.io.*;

public class Main3 {
    static int previousValue = 0;

    public static void main(String[] args) {


        //read file into stream, try-with-resources
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            reader.lines().forEach(
                    line -> {
                        var el = Integer.parseInt(line);
                        if (previousValue == el) {
                            return;
                        }
                        System.out.println(el);
                        previousValue = el;
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
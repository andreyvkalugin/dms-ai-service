package ru.kalugin.ai.yandex.src.com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main2 {
    static int previousValue = 0;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        PrintWriter writer = new PrintWriter("C:/Users/User/fileOut.txt", "UTF-8");

        String fileName = "C:/Users/User/file.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(
                    line -> {
                        var el = Integer.parseInt(line);
                        if (previousValue == el) {
                            return;
                        }
                        writer.println(String.valueOf(el));
                        previousValue = el;
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
            writer.close();
        }
        writer.close();
    }

}
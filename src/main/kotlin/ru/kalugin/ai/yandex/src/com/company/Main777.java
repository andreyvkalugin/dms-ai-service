package ru.kalugin.ai.yandex.src.com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main777 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int res = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            if (!"".equals(line) && Integer.parseInt(line) == 1) {
                count++;
                System.out.println("count: " + count);
            } else {
                if (count > res) {
                    res = count;
                }
                count = 0;
                if ("".equals(line)) break;
            }


            line = reader.readLine();
        }

        System.out.println(res);
    }

}
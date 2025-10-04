package ru.kalugin.ai.yandex.src.test;

import java.util.*;
import java.util.stream.Collectors;


public class NumberOfLand {
    public static void main(String[] args) {
        char[][] land = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumberOfLand().numIslands(land));
    }

    public int numIslands(char[][] grid) {
        List<Set<Map<Integer, Integer>>> set = new ArrayList<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (Character.getNumericValue(grid[x][y]) == 1) {
                    inGrid(x, y, set);
                }
            }
        }
        return set.size();
    }

    private void inGrid(int x, int y, List<Set<Map<Integer, Integer>>> set) {
        //set это острова
        //вложенный сет это уже облако точек
        var flag = false;
        List<Set<Map<Integer, Integer>>> tempSet = new ArrayList<>();
        for (var s : set) {
            if (s.contains(Map.of(x - 1, y)) || s.contains(Map.of(x, y - 1))) {
                s.add(Map.of(x, y));
                tempSet.add(s);
                flag = true;
            }
        }

        if (tempSet.size() > 1) {
            //  set.forEach(el -> System.out.println("Address: " + VM.current().addressOf(el)));
            for (var tt : tempSet) {
                //      System.out.println("Set: " + set);
                //      set.forEach(s-> System.out.println("eqls"+ s.equals(tt)));
                //      System.out.println("Set contains tt? " + set.contains(tt));
                var r = set.remove(tt);
                //      System.out.println("tt: " + tt);
                //      System.out.println("tt Address: " + VM.current().addressOf(tt));
                //      System.out.println("is removed? " + r);
            }
            set.add(tempSet.stream().flatMap(Collection::stream).collect(Collectors.toSet()));
        }

        if (!flag) {
            var st = new HashSet<Map<Integer, Integer>>();
            st.add(Map.of(x, y));
            set.add(st);
        }
    }
}

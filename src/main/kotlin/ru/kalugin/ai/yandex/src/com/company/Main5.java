package ru.kalugin.ai.yandex.src.com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main5 {
    static int count = 0;
    ////////рассчитаем вершины (Nомер вершины + список ребер и их вес)
    static Map<Integer, List<Map<Integer, Long>>> vertexList = new HashMap<>();
    //просмотрено и какой вес
    static Map<Integer, Long> lookedVertex = new HashMap<>();
    //сколько ребер прошли
    static Map<Integer, Integer> edgesToVertex = new HashMap<>();

    public static void main(String[] args) throws Exception {

        var XYcoord = new ArrayList<Map<String, Integer>>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считаем сначала первую строку
        String lineJ = reader.readLine();
        XYcoord.add(getChars(lineJ));
        String lineS = reader.readLine();
        XYcoord.add(getChars(lineS));
        String lineF = reader.readLine();
        XYcoord.add(getChars(lineF));
        String lineX = reader.readLine();
        XYcoord.add(getChars(lineX));


        for (var vertx : XYcoord) {
            lookedVertex.put(vertx.get("vertex"), -1L);
        }
        lookedVertex.put(1, 0L);

////////рассчитаем вершины (Nомер вершины + список ребер и их вес)


        for (var point : XYcoord) {
            var edges = new ArrayList<Map<Integer, Long>>();
            for (var pointInner : XYcoord) {
                if (point.get("vertex") == 1 && pointInner.get("vertex") == 2) continue;
                if (point.get("vertex") == 2 && pointInner.get("vertex") == 1) continue;
                if (Objects.equals(point.get("vertex"), pointInner.get("vertex"))) continue;
                var vertexBtwn = round(sqrt(pow((point.get("X") - pointInner.get("X")), 2) +
                        pow((point.get("Y") - pointInner.get("Y")), 2)));
                edges.add(Map.of(pointInner.get("vertex"), vertexBtwn));
            }
            vertexList.put(point.get("vertex"), edges);
        }
        System.out.println(vertexList);

////сновная логика
        var stackForSeen = new ArrayList<Integer>();
        stackForSeen.add(1);

        dfs(stackForSeen);
        System.out.println("result: " + lookedVertex);
        System.out.println("edges: " + edgesToVertex);


    }

    private static void dfs(ArrayList<Integer> stackForSeen) {
        var newStackForSeen = new ArrayList<Integer>();
        for (var el : stackForSeen) {
            for (var vert : vertexList.get(el)) {
                //var newStackForSeen = new ArrayList<Integer>();
                vert.forEach((k, v) -> {
                    if (lookedVertex.get(k) < 0 || lookedVertex.get(k) > (v + lookedVertex.get(el))) {
                        newStackForSeen.add(k);
                        var olr = lookedVertex.get(el);
                        var been = edgesToVertex.getOrDefault(el, 0);
                        lookedVertex.put(k, v + olr);
                        var c = edgesToVertex.getOrDefault(k, 0);
                        edgesToVertex.put(k, ++c + been);
                    }
                });
                //dfs(newStackForSeen);
            }
        }
        if (!newStackForSeen.isEmpty()) dfs(newStackForSeen);
    }

    private static Map<String, Integer> getChars(String line) {
        var res = new HashMap<String, Integer>();
        count++;
        for (int i = 0; i < 2; i++) {
            var a = line.charAt(i);
            if (i == 0) {
                res.put("X", Integer.parseInt(String.valueOf(a)));
            } else {
                res.put("Y", Integer.parseInt(String.valueOf(a)));
            }

            res.put("vertex", count);
        }
        System.out.println(res);
        return res;
    }

}
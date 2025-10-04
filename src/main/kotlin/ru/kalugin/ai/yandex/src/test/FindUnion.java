package ru.kalugin.ai.yandex.src.test;

public class FindUnion {

    int[] parent;

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(new FindUnion().validPath(3, arr, 0, 2));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];

        for (var i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (var arr : edges) {
            union(arr[0], arr[1]);
        }

        return findz(source) == findz(destination);
    }

    private void union(int i, int j) {
        parent[findz(i)] = findz(j);
    }

    private int findz(int el) {
        if (parent[el] != el) {
            parent[el] = findz(parent[el]);
            return parent[el];
        }
        return el;
    }
}
//https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/


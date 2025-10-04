package ru.kalugin.ai.yandex.src.com.company;


import java.util.LinkedList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        var res = partitionLabels("ababcbacadefegdehijhklij");
        //var res = partitionLabels("j");
        System.out.println(res);
    }

    static public List<Integer> partitionLabels(String s) {
        return getArrays(s, new LinkedList<Integer>());
    }

    private static List<Integer> getArrays(String s, LinkedList<Integer> resList) {
        var chArr = s.toCharArray();
        var l = 0;
        var r = s.length() - 1;
        var rightBorder = 0;
        while (l <= rightBorder) {
            if (chArr[r] != chArr[l]) {
                r--;
            } else {
                rightBorder = Math.max(r, rightBorder);
                l++;
                r = s.length() - 1;
            }
        }
        resList.add(s.substring(0, rightBorder + 1).length());
        if (!s.substring(rightBorder + 1).isEmpty()) {
            getArrays(s.substring(rightBorder + 1), resList);
        }
        return resList;
    }
}

package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56m {
    public static void main(String[] args) {
        var a = merge(new int[][]{{1, 3}, {2, 6}, {5, 8}});
        System.out.println(Arrays.deepToString(a));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][2]);
    }

//    public static int[][] merge(int[][] intervals) {
//        if(intervals == null || intervals.length <= 1) return intervals;
//        Arrays.sort(intervals, (a, b)->{
//            return a[0] == b[0] ? a[1] - b[1]: a[0] - b[0];
//        });
//        int len = intervals.length;
//        List<int[]> result = new ArrayList<>();
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        for(int i = 1; i < len; i++){
//            var iElStart= intervals[i][0];
//            if(iElStart <= end){
//                var iElLast = intervals[i][1];
//                end = Math.max(iElLast,end);
//            }else{
//                var iElLast = intervals[i][1];
//                result.add(new int[]{start, end});
//                start = intervals[i][0];
//                end = Math.max(iElLast,end);
//            }
//        }
//        result.add(new int[]{start, end});
//        return result.toArray(new int[result.size()][2]);
//    }
}

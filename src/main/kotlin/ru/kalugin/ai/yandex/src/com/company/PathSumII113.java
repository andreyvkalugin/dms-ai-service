package ru.kalugin.ai.yandex.src.com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathSumII113 {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(pathSum(getNode(), 22));
    }

    static public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result.clear();
        Map<UUID, List<Integer>> map = new HashMap<>();
        if (Objects.isNull(root)) {
            return result;
        }
        getTreeNodeList(root, map).forEach(uuid -> {
            var arr = map.get(uuid);
            if (arr.stream().mapToInt(i -> i).sum() == targetSum) {
                Collections.reverse(arr);
                result.add(arr);
            }
        });
        return result;
    }

    private static List<UUID> getTreeNodeList(TreeNode tnel, Map<UUID, List<Integer>> map) {
        List<UUID> uuid1 = null;
        if (Objects.nonNull(tnel.left)) {
            uuid1 = getTreeNodeList(tnel.left, map);
            uuid1.forEach(uuid -> {
                map.get(uuid).add(tnel.val);
            });
        }
        List<UUID> uuid2 = null;
        if (Objects.nonNull(tnel.right)) {
            uuid2 = getTreeNodeList(tnel.right, map);
            uuid2.forEach(uuid -> {
                map.get(uuid).add(tnel.val);
            });
        }

        if (Objects.isNull(tnel.right) && Objects.isNull(tnel.left)) {
            var uuid = UUID.randomUUID();
            var arrList = new ArrayList<Integer>();
            arrList.add(tnel.val);
            map.put(uuid, arrList);
            return List.of(uuid);
        }

        if (uuid1 == null) {
            return uuid2;
        }

        if (uuid2 == null) {
            return uuid1;
        }

        return Stream.concat(uuid1.stream(), uuid2.stream())
                .collect(Collectors.toList());
    }


    private static TreeNode getNode() {
        var node43 = new TreeNode(5);
        var node44 = new TreeNode(1);
        var node45 = new TreeNode(7);
        var node46 = new TreeNode(2);
        var node31 = new TreeNode(13);
        var node32 = new TreeNode(4, node43, node44);
        var node33 = new TreeNode(11, node45, node46);
        var node21 = new TreeNode(8, node31, node32);
        var node22 = new TreeNode(4, node33, null);
        var node11 = new TreeNode(5, node21, node22);
        return node11;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package ru.kalugin.ai.yandex.src.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        var tmp = new PathSum();

        System.out.println(tmp.pathSum(tmp.getNode(), 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        pathSum(root, sum, 0, result, new ArrayList<Integer>());
        return result;
    }

    private static void pathSum(TreeNode root, int sum, int count, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            if (count == sum) {
                result.add(new ArrayList<Integer>(list));
            }
        } else {
            list.add(root.val);
            if (root.left == null && root.right == null) {
                pathSum(root.left, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            } else if (root.left != null && root.right == null) {
                pathSum(root.left, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            } else if (root.right != null && root.left == null) {
                pathSum(root.right, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            } else {
                pathSum(root.left, sum, count + root.val, result, list);
                pathSum(root.right, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        var list = new ArrayList<Integer>();
        return getSumFromNode(root, list, sum);
    }

    private List<List<Integer>> getSumFromNode(TreeNode root, List<Integer> list, int sum) {

        var s = list.stream().mapToInt(y -> y).sum();
        if (s == sum) {
            return list.isEmpty() ? List.of() : List.of(list);
        }
        if (root == null || s > sum) return List.of();
        if ((s + root.val) == sum) {
            list.add(root.val);
            return List.of(list);
        }

        list.add(root.val);
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> listL = getSumFromNode(root.left, new LinkedList<>(list), sum);
        List<List<Integer>> listR = getSumFromNode(root.right, new LinkedList<>(list), sum);

        if (listR != null && !listR.isEmpty()) res.addAll(listR);
        if (listL != null && !listL.isEmpty()) res.addAll(listL);

        return res;
    }

    private TreeNode getNode() {
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}



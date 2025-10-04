package ru.kalugin.ai.yandex.src.com.company;

import java.util.Objects;

public class BalancedBinaryTree110 {

    public static void main(String[] args) {

        ///Решение не верно!!!!!!
        System.out.println(isBalanced(getNode()));
    }

    private static TreeNode getNode() {
        var node51 = new TreeNode(5);
        var node52 = new TreeNode(5);
        var node41 = new TreeNode(4, node51, node52);
        var node42 = new TreeNode(4);
        var node43 = new TreeNode(4);
        var node44 = new TreeNode(4);
        var node45 = new TreeNode(4);
        var node46 = new TreeNode(4);
        var node31 = new TreeNode(3, node41, node42);
        var node32 = new TreeNode(3, node43, node44);
        var node33 = new TreeNode(3, node45, node46);
        var node34 = new TreeNode(3);
        var node21 = new TreeNode(2, node31, node32);
        var node22 = new TreeNode(2, node33, node34);
        var node11 = new TreeNode(1, node21, node22);
        return node11;
    }

    public static boolean isBalanced(TreeNode root) {
        var max = getTreeNodeListMax(root, 0);
        var min = getTreeNodeListMin(root, 0);
        if (max == min) {
            return max < 2;
        }
        return (max - min) <= 2;
    }

    private static int getTreeNodeListMax(TreeNode tnel, int count) {
        if (Objects.isNull(tnel) || (Objects.isNull(tnel.left) && Objects.isNull(tnel.right))) {
            return count;
        }
        var l = 0;
        var r = 0;
        count++;
        if (Objects.nonNull(tnel.left)) l = getTreeNodeListMax(tnel.left, count);
        if (Objects.nonNull(tnel.right)) r = getTreeNodeListMax(tnel.right, count);
        return Math.max(l, r);
    }

    private static int getTreeNodeListMin(TreeNode tnel, int count) {
        if (Objects.isNull(tnel) || (Objects.isNull(tnel.left) && Objects.isNull(tnel.right))) {
            return count;
        }
        var l = Integer.MAX_VALUE;
        var r = Integer.MAX_VALUE;
        count++;
        if (Objects.nonNull(tnel.left)) l = getTreeNodeListMin(tnel.left, count);
        if (Objects.nonNull(tnel.right)) r = getTreeNodeListMin(tnel.right, count);
        return Math.min(l, r);
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


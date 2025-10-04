package ru.kalugin.ai.yandex.src.com.company;

public class BalancedBinaryTree110I {


    public static void main(String[] args) {
        System.out.println(isBalanced(getNode()));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
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
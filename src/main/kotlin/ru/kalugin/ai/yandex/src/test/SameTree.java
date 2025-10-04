package ru.kalugin.ai.yandex.src.test;

public class SameTree {

    public static void main(String[] args) {
        var node12 = new TreeNode(2);
        var node13 = new TreeNode(3);
        var node11 = new TreeNode(1, node12, node13);
        var node22 = new TreeNode(2);
        var node23 = new TreeNode(3);
        var node21 = new TreeNode(1, node22, node23);

        System.out.println(new SameTree().isSameTree(node11, node21));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (q != null && p == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}








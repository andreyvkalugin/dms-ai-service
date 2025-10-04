package ru.kalugin.ai.yandex.src.com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var tnp = new LinkedList<Integer>();
        getTreeNodeList(p, tnp);
        var tnq = new LinkedList<Integer>();
        getTreeNodeList(q, tnq);
        return tnp.equals(tnq);
    }

    private void getTreeNodeList(TreeNode tnel, List<Integer> resultingTreeNodeList) {
        if (Objects.nonNull(tnel)) {
            resultingTreeNodeList.add(tnel.val);
            getTreeNodeList(tnel.left, resultingTreeNodeList);
            getTreeNodeList(tnel.right, resultingTreeNodeList);
        } else {
            resultingTreeNodeList.add(Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        var a = new int[]{11, 12, 13, 14, 0, 1, 2};
        var l = 0;
        var r = a.length;
        var pivot = (a.length / 2);
        while (l + 1 < r) {
            if (a[pivot] > a[r]) {
                l = pivot;
            } else {
                r = pivot;
            }

        }
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
}

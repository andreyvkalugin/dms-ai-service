package ru.kalugin.ai.yandex.src.com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathSumII113m {
    static List<List<Integer>> result = new ArrayList<>();

    // public static void main(String[] args) {
    //     System.out.println(pathSum(getNode(),22));
    //  }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result.clear();
            getTreeNodeList(root, new ArrayList<Integer>(), targetSum);
            return result;
        }

        private void getTreeNodeList(TreeNode tnel, List<Integer> innerTreeNodeList, int targetSum) {
            if (Objects.isNull(tnel)) {
                return;
            }

            innerTreeNodeList.add(tnel.val);

            if (Objects.isNull(tnel.right) && Objects.isNull(tnel.left) && isSumEqToTarget(innerTreeNodeList, targetSum)) {
                result.add(innerTreeNodeList);
            }

            if (Objects.nonNull(tnel.left)) getTreeNodeList(tnel.left, new ArrayList<>(innerTreeNodeList), targetSum);
            if (Objects.nonNull(tnel.right)) getTreeNodeList(tnel.right, new ArrayList<>(innerTreeNodeList), targetSum);
        }

        private boolean isSumEqToTarget(List<Integer> innerTreeNodeList, int targetSum) {
            return innerTreeNodeList.stream().mapToInt(i -> i).sum() == targetSum;
        }
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

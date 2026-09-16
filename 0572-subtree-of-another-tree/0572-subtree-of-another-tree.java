/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return solve(root,subRoot);  
    }
 boolean solve(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return solve(root.left, subRoot)
            || solve(root.right, subRoot);
    }

    boolean sameTree(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return sameTree(a.left, b.left)
            && sameTree(a.right, b.right);
    }
}
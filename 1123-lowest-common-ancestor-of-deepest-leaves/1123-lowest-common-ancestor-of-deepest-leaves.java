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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).node;
    }
    class Result{
        TreeNode node;
        int depth;

        Result(TreeNode node,int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    Result solve(TreeNode root){
            if(root == null){
                return new Result(null,0);
            }
            Result left = solve(root.left);
            Result right = solve(root.right);

            //left subtree is deepest
            if(left.depth > right.depth){
                return new Result(left.node,left.depth + 1);
            }

            //right subtree is the deepest

            if(right.depth > left.depth){
                return new Result(right.node,right.depth + 1);
            }

            //both depht are same s0
            return new Result(root,left.depth + 1);
    }
}
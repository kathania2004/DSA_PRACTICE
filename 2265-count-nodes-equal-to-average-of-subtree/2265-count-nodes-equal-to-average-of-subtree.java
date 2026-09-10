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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
    Result solve(TreeNode root){
        if(root == null){
            return new Result(0,0);
        }
        Result left = solve(root.left);
        Result right = solve(root.right);

        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        if(root.val == sum/count){
            ans++;
        }
        return new Result(sum,count);
    }
    class Result{
        int sum;
        int count;

        Result(int sum,int count){
            this.sum = sum;
            this.count = count;
        }
    }
}
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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root,"");
        return ans;
    }
    void solve(TreeNode root,String path){
        if(root == null){
            return;
        }
        //add current node to path
        if(path.equals("")){
            path = path + root.val;
        }else{
            path = path + "->" + root.val;
        }

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        solve(root.left,path);
        solve(root.right,path);
        
    }
}
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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return postRoot(inorder,postorder,0,inorder.length - 1);
    }
    private TreeNode postRoot(int[] inorder,int[] postorder,int left,int right){
        if(left > right){
            return null;
        }

        int rootValue = postorder[postIndex];
        postIndex--;
        TreeNode root = new TreeNode(rootValue);

        int index = right;

        while(inorder[index] != rootValue){
            index--;
        }

        root.right = postRoot(inorder,postorder,index + 1,right);
        root.left = postRoot(inorder,postorder,left,index - 1);

        return root;
    }
}
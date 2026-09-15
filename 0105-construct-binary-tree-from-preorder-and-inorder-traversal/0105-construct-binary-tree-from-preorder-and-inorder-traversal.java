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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rootValue(preorder,inorder,0,inorder.length - 1);

    }
    private TreeNode rootValue(int[] preorder,int[] inorder,int left,int right){
        if(left > right){
            return null;
        }

        int rootvalue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootvalue);

        int index = left;
        
        while(inorder[index] != rootvalue){
            index++;
        }

        root.left = rootValue(preorder,inorder,left,index - 1);
        root.right = rootValue(preorder,inorder,index + 1,right);
        return root;
    }
}
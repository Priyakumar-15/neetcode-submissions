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
    public boolean isValidBstutil(TreeNode root ,int min,int max) {
       if(root == null) return true;
       if(root.val <= min || root.val >= max){
        return false;
       }
       return isValidBstutil(root.left,min,root.val) && isValidBstutil(root.right,root.val,max);
    }
       
    
    public boolean isValidBST(TreeNode root) {
        
        return isValidBstutil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}

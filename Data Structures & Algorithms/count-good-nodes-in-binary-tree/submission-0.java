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
    public int cnt=0;
    public void cntNodes(TreeNode root,int upperbound){
         if(root==null) return;
         if(root.val >= upperbound) cnt++;
         upperbound=Math.max(upperbound,root.val);
        cntNodes(root.left,upperbound);
        cntNodes(root.right,upperbound);
        return;

    }
    
    public int goodNodes(TreeNode root) {
       
       cntNodes(root,root.val);
       return cnt;
    }
}

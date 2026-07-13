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
    private int K;
    private int res;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(--K == 0) {
            res=root.val;
            return;
        }
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
       this.K=k;
       this.res=-1;
       dfs(root);
       return res;
    }
}

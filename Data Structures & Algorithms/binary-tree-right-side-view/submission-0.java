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
    public void rightdfs(TreeNode root,List<Integer> res,int level){
        if(root == null){
            return;
        }
        if(level == res.size()) res.add(root.val);
        rightdfs(root.right,res,level+1);
        rightdfs(root.left,res,level+1);

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root == null){
            return res;
        }
        rightdfs(root,res,0);
        return res;
    }
}

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
    public TreeNode buildtreeutil(int[] preorder,int prest,int prend, int[] inorder,int inst,int inend,HashMap<Integer,Integer> inmap){
        if(prest > prend || inst > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prest]);
        int inroot=inmap.get(root.val);
        int numsleft=inroot-inst;
        root.left=buildtreeutil(preorder,prest+1,prest+numsleft,inorder,inst,inroot-1,inmap);
        root.right=buildtreeutil(preorder,prest+numsleft+1,prend,inorder,inroot+1,inend,inmap);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        return buildtreeutil(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);

    }
}

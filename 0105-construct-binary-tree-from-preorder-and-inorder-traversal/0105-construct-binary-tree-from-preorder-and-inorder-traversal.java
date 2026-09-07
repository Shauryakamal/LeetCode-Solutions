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
    private int preIndex = 0;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int rootIndex = map.get(root.val);
        root.left = buildTreeHelper(preorder,left,rootIndex - 1);
        root.right = buildTreeHelper(preorder,rootIndex + 1, right);
        return root;
    }
}
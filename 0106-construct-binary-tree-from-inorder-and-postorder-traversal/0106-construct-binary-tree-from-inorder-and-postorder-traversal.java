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
    private int postIndex;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex--]);

        int rootIndex = map.get(root.val);
        root.right = buildTreeHelper(postorder, rootIndex + 1, right);
        root.left = buildTreeHelper(postorder, left, rootIndex - 1);

        return root;
}
}
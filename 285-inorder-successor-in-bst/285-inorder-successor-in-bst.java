/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode succ = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
               return succ;
        }
        if(p.val < root.val ) {
            succ = root;
            return inorderSuccessor(root.left, p);
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}
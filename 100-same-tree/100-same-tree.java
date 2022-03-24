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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!check(p, q)) return false;
        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<TreeNode> qList = new LinkedList<>();
        pList.add(p);
        qList.add(q);
        while(!pList.isEmpty()) {
            TreeNode p1 = pList.removeFirst();
            TreeNode q1 = qList.removeFirst();
            if(!check(p1, q1)) {
                return false;
            }
            if(p1 != null) {
                if(!check(p1.left, q1.left)) {
                    return false;
                }
                if(p.left != null) {
                    pList.add(p1.left);
                    qList.add(q1.left);
                }
                if(!check(p1.right, q1.right)) {
                    return false;
                }
                if(p.right != null) {
                    pList.add(p1.right);
                    qList.add(q1.right);
                }
            }
        }
        return true;
    }
    
    private boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return true;
    }
}
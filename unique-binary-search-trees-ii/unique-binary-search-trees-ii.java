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

public List<TreeNode> generateTrees(int n, int lb, int ub) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode> possibleTrees = new ArrayList<>();
        for (int i=lb; i<=ub; i++) {
            List<TreeNode> left = generateTrees(i - lb, lb, i-1);
            List<TreeNode> right = generateTrees(ub - i, i+1, ub);
            
            if (left.size() > 0 && right.size() > 0) {
                for (TreeNode leftPossibility : left) {
                    for (TreeNode rightPossibility : right) {
                        possibleTrees.add(new TreeNode(i, leftPossibility, rightPossibility));
                    }
                }
            } else if (left.size() > 0) {
                for (TreeNode leftPossibility : left) {
                    possibleTrees.add(new TreeNode(i, leftPossibility, null));
                }
            } else if (right.size() > 0) {
                for (TreeNode rightPossibility : right) {
                    possibleTrees.add(new TreeNode(i, null, rightPossibility));
                }
            } else {
                possibleTrees.add(new TreeNode(i, null, null));
            }
            
        }
        return possibleTrees;
    }
    
    
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1, n);
    }
}
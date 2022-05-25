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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        leftMostInOrder(root);
    }
    private void leftMostInOrder(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode next = stack.pop();
        TreeNode right = next.right;
        if(right != null) {
           leftMostInOrder(right);
        }
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    
}
// Store all values in List while initiazing the object
// class BSTIterator {
//     int index;
//     ArrayList<Integer> list;
//     public BSTIterator(TreeNode root) {
//         list = new ArrayList<>();
//         index = -1;
//         inOrderTraversal(root);
//     }
    
//     public int next() {
//         return list.get(++index);
//     }
    
//     public boolean hasNext() {
//         return index + 1 < list.size();
//     }
    
//     private void inOrderTraversal(TreeNode root) {
//         if(root == null) {
//             return;
//         }
//         inOrderTraversal(root.left);
//         list.add(root.val);
//         inOrderTraversal(root.right);
//     }
// }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
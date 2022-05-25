class KthLargest {
    TreeNode root;
    int m_k;;
 
//     public int add(int val) {
//         root = insertNode(root, val);
//         return searchKth(root, m_k);
//     }
// }
    public KthLargest(int k, int[] nums) {
        root = null;
        for(int i = 0; i < nums.length; i++) {
            root = insertNode(root, nums[i]);    
        }
        m_k = k;
    }
    
    public int add(int val) {
        root = insertNode(root,val);
        return searchKth(root, m_k);
    }
    
//     private TreeNode insert(TreeNode root, int val) {
//         if(root == null) {
//             return new TreeNode(val, 1);
//         }
//         if(root.val > val) {
//             root.left = insert(root.left, val);
//         } else {
//             root.right = insert(root.right, val);
//         }
//         root.count++;
//         return root;
//     }
    
//     private int searchKthLargest(TreeNode root, int k) {
//         int m = root.right != null ? root.right.count: 0;
//         if(k == m+1) {
//             return root.val;
//         } else if(k <= m ) {
//             return searchKthLargest(root.right, k);
//         } else {
//             return searchKthLargest(root.left, k-m-1);
//         }
//     }
    
    private TreeNode insertNode(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num, 1);
        }
        if (root.val < num) {
            root.right = insertNode(root.right, num);
        } else {
            root.left = insertNode(root.left, num);
        }
        root.count++;
        return root;
    }

    private int searchKth(TreeNode root, int k) {
        // m = the size of right subtree
        int m = root.right != null ? root.right.count : 0;
        // root is the m+1 largest node in the BST
        if (k == m + 1) {
            return root.val;
        }
        if (k <= m) {
            // find kth largest in the right subtree
            return searchKth(root.right, k);
        } else {
            // find (k-m-1)th largest in the left subtree
            return searchKth(root.left, k - m - 1);
        }
    } 
}

class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */



// class KthLargest {
//     // insert a node into the BST
//     private Node insertNode(Node root, int num) {
//         if (root == null) {
//             return new Node(num, 1);
//         }
//         if (root.val < num) {
//             root.right = insertNode(root.right, num);
//         } else {
//             root.left = insertNode(root.left, num);
//         }
//         root.cnt++;
//         return root;
//     }

//     private int searchKth(Node root, int k) {
//         // m = the size of right subtree
//         int m = root.right != null ? root.right.cnt : 0;
//         // root is the m+1 largest node in the BST
//         if (k == m + 1) {
//             return root.val;
//         }
//         if (k <= m) {
//             // find kth largest in the right subtree
//             return searchKth(root.right, k);
//         } else {
//             // find (k-m-1)th largest in the left subtree
//             return searchKth(root.left, k - m - 1);
//         }
//     } 
    
//     private Node root;
//     private int m_k;

//     public KthLargest(int k, int[] nums) {
//         root = null;
//         for (int i = 0; i < nums.length; ++i) {
//             root = insertNode(root, nums[i]);
//         }
//         m_k = k;
//     }
    
//     public int add(int val) {
//         root = insertNode(root, val);
//         return searchKth(root, m_k);
//     }
// }

// class Node {    // the structure for the tree node
//     Node left;
//     Node right;
//     int val;
//     int cnt;    // the size of the subtree rooted at the node
//     public Node (int v, int c) {
//         left = null;
//         right = null;
//         val = v;
//         cnt = c;
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
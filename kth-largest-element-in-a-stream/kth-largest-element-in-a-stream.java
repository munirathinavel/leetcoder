class KthLargest {
    TreeNode root = null;
    int m_k = 0;
    
    public KthLargest(int k, int[] nums) {
        root = null;
        for(int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);    
        }
        m_k = k;
    }
    
    public int add(int val) {
        root = insert(root,val);
        return searchKthLargest(root, m_k);
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val, 1);
        }
        if(root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        root.count++;
        return root;
    }
    
    private int searchKthLargest(TreeNode root, int k) {
        int m = root.right != null ? root.right.count: 0;
        if(k == m+1) {
            return root.val;
        } else if(k <= m ) {
            return searchKthLargest(root.right, k);
        } else {
            return searchKthLargest(root.left, k-m-1);
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
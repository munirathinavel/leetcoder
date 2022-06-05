class MyHashSet {
    int range;
    Bucket[] buckets;

    public MyHashSet() {
        range = 769;
        buckets = new Bucket[range];
        for(int i =0; i < range; i++) {
            buckets[i] = new Bucket();
        }
    }
    
    private int hash(int key) {
        return key%range;
    }
    public void add(int key) {
        buckets[hash(key)].insert(key);
    }
    
    public void remove(int key) {
        buckets[hash(key)].delete(key);
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}

class Bucket {
    BSTree tree;
    Bucket(){
        tree = new BSTree();
    }
    
    public void insert(int key) {
        this.tree.root = tree.insert(tree.root, key);
    }
    
    public void delete(int key) {
        this.tree.root = tree.delete(tree.root, key);
    }
    
    public boolean contains(int key) {
        return tree.search(tree.root, key) != null;
    }
}

class BSTree {
    Node root = null;

    public Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }
        if(key > root.val) {
            root.right = insert(root.right, key);
        } else if(key < root.val) {
            root.left = insert(root.left, key);
        } else {
            return root;
        }
        return root;
    }
    
    public Node search(Node root, int key) {
        if(root == null || root.val == key) {
            return root;
        }
        return key > root.val ? search(root.right, key) : search(root.left, key);
    }
    
    private int successor(Node root) {
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    
    private int predecessor(Node root) {
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    public Node delete(Node root, int key) {
        if(root == null) {
            return null;
        }
        if(key > root.val) {
            root.right = delete(root.right, key);
        } else if(root.val > key) {
            root.left = delete(root.left, key);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.right != null) {
                root.val = successor(root);
                root.right = delete(root.right, root.val);
            }else  {
                root.val = predecessor(root);
                root.left = delete(root.left, root.val);
            } 
        }
         return root;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
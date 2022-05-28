class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge:edges) {
            int x = edge[0];
            int y = edge[1];
            if(x != y) {
                unionFind.union(x,y);
            }
        }
        return unionFind.getCount();
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    private int count = 0;
    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for(int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if(x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            if(rank[rootx] > rank[rooty]) {
                root[rooty] = rootx;
            } else if(rank[rootx] < rank[rooty]) {
                root[rootx] = rooty;
            } else {
                root[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int getCount() {
        return count;
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge [1];
            if(!uf.union(x, y)) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind {
    int[] root;
    UnionFind(int size) {
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }
    
    public int find(int x) {
        while(root[x] != x) {
            x = root[x];
        }
        return x;
    }
    
    public boolean union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty) {
            return false;
        }
        root[rooty] = rootx;
        return true;
    }
}
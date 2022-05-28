class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        UnionFind unionFind = new UnionFind((m+1) * (n +1));
        for(int r = 0; r < isConnected.length; r++) {
            for(int c = 0; c < isConnected[0].length; c++) {
                if( isConnected[r][c]  == 1 && r != c) {
                    unionFind.union(r,c);
                }
            }
        }
        Set<Integer> rootSet = new HashSet<>();
        for(int r = 0; r < isConnected.length; r++) {
            for(int c = 0; c < isConnected[0].length; c++) {
                if( isConnected[r][c]  == 1 && unionFind.connected(r,c)) {
                    rootSet.add(unionFind.find(r));
                }
            }
        }
        return rootSet.size();
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
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
        }
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}


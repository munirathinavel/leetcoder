class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer t1 = new Integer(log1[0]);
                Integer t2 = new Integer(log2[0]);
                return t1.compareTo(t2);
            }
        });
        UnionFind uf = new UnionFind(n);
        for(int[] log: logs) {
            if(uf.union(log[1], log[2]) == 1){
                return log[0];
            }
        }
        return -1;
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    int count = 0;
    UnionFind(int size){
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
    
    public int union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            if(rank[rootx] > rank[rooty]){
                root[rooty] = rootx;
                rank[rootx]++;
            } else if(rank[rootx] > rank[rooty]) {
                root[rootx] = rooty;
                rank[rooty]++;
            } else {
                root[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
        return count;
    }
    
}
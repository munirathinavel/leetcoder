class Solution {
    public int findCircleNum(int[][] isConnected) {
        int parent[] = new int[isConnected.length];
        Arrays.fill(parent, -1);
        for(int r = 0; r < isConnected.length; r++) {
            for(int c = 0; c < isConnected[0].length; c++) {
                if( isConnected[r][c]  == 1 && r != c) {
                    union(parent, r, c);
                }
            }
        }
        int count =0;
        for(int i=0; i < parent.length; i++) {
            if(parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
    public void union(int[] root, int x, int y) {
        int rootx = find(root, x);
        int rooty = find(root, y);
        if(rootx != rooty) {
            root[rooty] = rootx;
        }
    }
    public int find(int[] root, int x) {
        if(root[x] == -1) {
            return x;
        }
        return root[x] = find(root, root[x]);
    }
}


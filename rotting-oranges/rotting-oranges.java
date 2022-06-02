class Solution {
    int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int freshCount = 0;
        for(int i =0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) {
            return 0;
        }
        
        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i=0; i < size; i++) {
                int[] current = q.poll();
                if(grid[current[0]][current[1]]  != 2) {
                    continue;
                }
                for(int[] next:getAdj(current, grid)) {
                    if(grid[next[0]][next[1]] == 1) {
                        grid[next[0]][next[1]] = 2;
                        q.add(new int[]{next[0],next[1]});
                        freshCount--;
                    }
                }
                
            }
        }
       return freshCount == 0 ? count-1 : -1; 
    }
    private List<int[]> getAdj(int[] current, int[][] grid) {
        List<int[]> children = new ArrayList<>();
        int row = current[0];
        int col = current[1];
        for(int[] direction:directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != 1) {
                continue;
            }
            children.add(new int[]{newRow, newCol});
        }
        return children;
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dpGrid = new int[ n + 1][m + 1];
        
        // Iterate all rows & columns starting from last one,
        for(int row=n-1;row >= 0; row--) {
            for(int col =m-1; col >= 0; col--) {
                if(text1.charAt(row) == text2.charAt(col)) {
                    dpGrid[row][col] = 1 + dpGrid[row+1][col+1];
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row+1][col], dpGrid[row][col+1]);
                }
            }
        }
        return dpGrid[0][0];
    }
}

// Memoization
// class Solution {
//     private int[][] memo;
//     private String text1;
//     private String text2;
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         this.memo = new int[ n + 1][m + 1];
//         for(int i=0;i<n; i++) {
//             for(int j =0; j <m;j++) {
//                 memo[i][j] = -1;
//             }
//         }
//         this.text1 = text1;
//         this.text2 = text2;
//         return dp(0,0);
//     } 
//     private int dp(int p1, int p2) {
//         if(memo[p1][p2] != -1) {
//             return memo[p1][p2];
//         }
//         int answer = 0;
//         if(text1.charAt(p1) == text2.charAt(p2)) { 
//             answer = 1 + dp(p1+1, p2+1);
//         } else {
//             answer = Math.max(dp(p1, p2+1), dp(p1+1, p2));
//         }
//         memo[p1][p2] = answer;       
//         return memo[p1][p2];
//     }
// }
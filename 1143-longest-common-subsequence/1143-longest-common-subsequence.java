class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        // Previous column starts with all 0s 7 like before is 1 more than the length of the first word.
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];
        
        // Iterate all rows & columns starting from last one,
        for(int col=text2.length()-1;col >= 0; col--) {
            for(int row =text1.length()-1; row >= 0; row--) {
                if(text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row+1];
                } else {
                    current[row] = Math.max(previous[row], current[row+1]);
                }
            }
            // Current column becomes previous column
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[0];
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
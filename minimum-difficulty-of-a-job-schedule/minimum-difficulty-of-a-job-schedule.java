// Bottom up Approach
class Solution {
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        // If we cannot schedule at least one job per day, 
        // it is impossible to create a schedule
        if (n < d) {
            return -1;
        }
        
        // Initialize memo array with value of -1.
        int dp[][] = new int[n][d + 1];
        for (int[] row:dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Set base cases
        dp[n-1][d] = jobDifficulty[n-1];
        
        // Set values for last day on each row
        for(int i = n-2; i >=0; i--) {
            dp[i][d] = Math.max(dp[i+1][d], jobDifficulty[i]);
        }
        
        for(int day = d -1; day >0; day--) {
            for(int i = day-1; i < n - (d-day); i++) {
                int hardest = 0;
                for(int j = i; j < n - (d - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j+1][day + 1]);
                }
            }
        } 
        return dp[0][1];
   }
}

// Top Down Appraoch:

// class Solution {
//     int[] hardestJobRemaining;
//     int d;
//     int jobDifficulty[];
//     int n;
//     int memo[][];
    
//     int dp(int i, int day) {
//         // Base case, it's the last day so we need to finish all the jobs
//         if(day == d) {
//             return hardestJobRemaining[i];
//         }

//         if(memo[i][day] == -1) {
//             int best = Integer.MAX_VALUE;
//             int hardest = 0;
//             for(int j = i; j < n - (d - day); j++) {
//                 hardest = Math.max(hardest, jobDifficulty[j]);
//                 best = Math.min(best, hardest + dp(j+1, day + 1));
//             }
//             memo[i][day] = best;
//         }
       
//         return memo[i][day];
//     }
    
//     public int minDifficulty(int[] jobDifficulty, int d) {
//         n = jobDifficulty.length;
//         // If we cannot schedule at least one job per day, 
//         // it is impossible to create a schedule
//         if (n < d) {
//             return -1;
//         }
        
//         hardestJobRemaining = new int[n];
//         int hardestJob = 0;
//         for (int i = n - 1; i >= 0; i--) {
//             hardestJob = Math.max(hardestJob, jobDifficulty[i]);
//             hardestJobRemaining[i] = hardestJob;
//         }
        
//         // Initialize memo array with value of -1.
//         memo = new int[n][d + 1];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(memo[i], -1);
//         }
        
//         this.d = d;
//         this.jobDifficulty = jobDifficulty;
//         return dp(0, 1);
//    }
// }
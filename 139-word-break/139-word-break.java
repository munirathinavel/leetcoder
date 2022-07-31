// Bottom-up Tabular Approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<String>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j=0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
     }
}

// Memoized Top Down Recursion
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return wordBreakMemo(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);   
//     }
    
//     private boolean wordBreakMemo(String s, HashSet<String> wordDict, int start, Boolean[] memo) {
//         if(start == s.length()) {
//             return true;
//         }
//         if(memo[start] != null){
//             return memo[start];
//         }
//         for(int end = start + 1; end <= s.length(); end++) {
//             if(wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
//                 return memo[start] = true;
//             }
//         }
//         return memo[start] = false;
//      }
// }

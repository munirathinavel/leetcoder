class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] arr = new int[128];
        for(int i=0, j=0;i < s.length(); i++) {
            char c = s.charAt(i);
            j = Math.max(j, arr[c]);
            ans = Math.max(ans, i-j+1);
            arr[c]=  i+1;
        }
        return ans;
    }
}
 
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int ans = 0;
//         Map<Character, Integer> map = new HashMap<>();
//         for(int i=0, j=0;i < s.length(); i++) {
//             char c = s.charAt(i);
//             if(map.containsKey(c)) {
//                 j = Math.max(j, map.get(c));
//             }
//             ans = Math.max(ans, i-j+1);
//             map.put(c, i+1);
//         }
//         return ans;
//     }
// }
 
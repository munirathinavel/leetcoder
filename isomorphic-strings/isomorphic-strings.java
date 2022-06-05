class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s1 = new int[256];
        int[] t1 = new int[256];
        for(int i=0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(s1[c1] != t1[c2]) {
                return false;
            }
            s1[c1] = i+1;
            t1[c2] = i+1;
        }
        return true;
    }
    
    
}

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length() != t.length()) {
//             return false;
//         }
//         return getIndexString(s).equals(getIndexString(t));
//     }
    
//     private String getIndexString(String s) {
//         Map<Character,Integer> indexMap = new HashMap<>();
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             // indexMap.put(c, indexMap.getOrDefault(c,i) + 1);
//             if (!indexMap.containsKey(c)) {
//                 indexMap.put(c, i);
//             }
//             indexMap.putIfAbsent(c, i);
//             sb.append(Integer.toString(indexMap.get(c)));
//             sb.append(" ");
//         }
//         System.out.println(sb.toString());
//         return sb.toString();
//     }
// }
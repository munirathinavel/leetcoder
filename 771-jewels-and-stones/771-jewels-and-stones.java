class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char c:jewels.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for(char c: stones.toCharArray()) {
            if(set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}

// class Solution {
//     public int numJewelsInStones(String jewels, String stones) {
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c: stones.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         int count = 0;
//         for(char c:jewels.toCharArray()) {
//             if(map.containsKey(c)) {
//                 count += map.get(c);
//             }
//         }
//         return count;
//     }
// }
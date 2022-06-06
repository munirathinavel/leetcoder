class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] a = new int[26];
        for(String s: strs) {
            Arrays.fill(a,0);
            for(char c: s.toCharArray()) {
                a[c - 'a']++; 
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < a.length; i++) {
                sb.append('#');
                sb.append(a[i]);
            }
            // char[] c = s.toCharArray();
            // Arrays.sort(c);
            String key = sb.toString();;
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
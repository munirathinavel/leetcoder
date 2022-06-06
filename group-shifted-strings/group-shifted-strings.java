class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strings) {
            String hashKey = getHash(s);
            map.putIfAbsent(hashKey, new ArrayList());
            map.get(hashKey).add(s);
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }
    
    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i < chars.length; i++) {
            sb.append((char)((chars[i] - chars[i-1] + 26) % 26 + 'a'));
        }
        return sb.toString();
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        return getIndexString(s).equals(getIndexString(t));
    }
    
    private String getIndexString(String s) {
        Map<Character,Integer> indexMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            indexMap.putIfAbsent(c, i);
            sb.append(Integer.toString(indexMap.get(c)));
            sb.append(" ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
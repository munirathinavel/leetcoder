class Solution {
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> combinations = new ArrayList<>();
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return combinations;
        }
        this.phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }
    private void backtrack(int index, StringBuilder sb) {
        if(sb.length() == phoneDigits.length()) {
            combinations.add(sb.toString());
            return; 
        }
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for(char c : possibleLetters.toCharArray()) {
            sb.append(c);
            backtrack(index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
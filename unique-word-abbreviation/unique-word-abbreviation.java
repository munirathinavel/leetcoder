class ValidWordAbbr {
    Map<String, String> lookup = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String word: dictionary) {
            String abbr = getAbbr(word);
            if(!lookup.containsKey(abbr)) {
                lookup.put(abbr, word);
            } else if(!lookup.get(abbr).equals(word)) {
                lookup.put(abbr, "");
            }
        }
    }
    
    private String getAbbr(String word) {
        if(word.length() <= 2) {
            return word;
        } else {
            int length = word.length() -2;
            return "" +word.charAt(0) + length + word.charAt(word.length()-1);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(!lookup.containsKey(abbr)) {
            return true;
        } 
        return lookup.get(abbr).equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
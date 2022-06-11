class ValidWordAbbr {
    Map<String, Set<String>> lookup = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String word: dictionary) {
            String abbr = getAbbr(word);
            if(!lookup.containsKey(abbr)) {
                lookup.put(abbr, new HashSet<String>());
            } 
            lookup.get(abbr).add(word);
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
        return !lookup.containsKey(abbr) || lookup.get(abbr).contains(word) && lookup.get(abbr).size() == 1;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
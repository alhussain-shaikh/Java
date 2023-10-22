public class WordBreak {
    
    // function that will call wordBreakMemo
    // and return True or False on its basis
    public boolean word_Break(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    // recursive function to perform wordbreak
    // and return True or False
    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        
        //base case to check whether
        // the whole string is exhausted,
        // in that case return a `true`
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        
        // check every possible prefix
        // of the string in the 
        // dictionary of words.
        for (int end = start + 1; end <= s.length(); end++) {
            // If substring is found in the `worddict`, 
           // recursively call the function
           // for the remaining portion
           // of the string
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}

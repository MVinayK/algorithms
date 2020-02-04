import java.util.HashMap;
import java.util.Map;

class LongestPalindrome {

    public int findLongestPalindrome(String str) {
        return longestPalindrome(str, 0, str.length() - 1);
        //return longestPalindromeMemo(str, 0, str.length(), new HashMap<String, Integer>());
    }

    private int longestPalindrome(String str, int i, int j) {

        /* Base cases for termination while recursion */
        if(i == (str.length() - 1) || j <= 0 || i > j) {
            return 0;
        }

        if(i == j) {
            return 1;
        }

        if(str.charAt(i) == str.charAt(j)) {
            return 2 + longestPalindrome(str, i + 1, j - 1);
        }

        return Math.max(longestPalindrome(str, i + 1, j), longestPalindrome(str, i, j -1));
    }
/*
    private int longestPalindromeMemo(String str, int i, int j, Map<String, Integer> memo) {

        if(i == (str.length() - 1) || j <= 0 || i > j) {
            return 0;
        }

        if(i == j) {
            return 1;
        }

        if(memo.get(str) != null) {
            return memo.get(str);
        }

        if(str.charAt(i) == str.charAt(j)) {
             memo.put(str, 2 + longestPalindrome(str, i + 1, j - 1));
             memo.get(str);
        }

        memo.put(str, Math.max(longestPalindrome(str, i + 1, j), longestPalindrome(str, i, j -1)));
        return memo.get(str);
    }
*/
}
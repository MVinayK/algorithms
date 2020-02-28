public class MinEdits {

    /**
     * Problem : Given 2 string tell the min no of edits (insert , delete , replace ) that we have to do
     * in order to make both the strings same ?
     * 
     * Ex : books, kooks --> ans = 2 
     * @param str1
     * @param str2
     * @return
     */

    public int minEdits(String str1, String str2) {

        return minEdits(str1, str2, str1.length() - 1, str2.length() -1);
    }


    private int minEdits(String str1, String str2, int i, int j) {

        /** 
         * This case is the base case , what it does ?
         * Now any of the strings can come to an end i.e all characters have been compared 
         * in that case we should return 0 (no more comparisons)
         * 
         * But if one string is longer than the other then the no of extra characters will be the total cost of either deleting
         * in the longer string or inserting in the shorter string . so returned the extra characters 
        */
        if(i < 0 || j < 0) {
            return i < 0 ? j >= 0 ? j : 0 : i;
        }
        /**
         * This case is written when the characters at that positions are matching then practically no edits are required
         * we can just check for rest of the remaining substrings in both the strings
         */
        if(str1.charAt(i) == str2.charAt(j)) {
            return minEdits(str1, str2, i-1, j-1);
        } 

        /** 
         * Here at the end we may end up with three simple case :
         * 
         * 1. we have to add a charater in the first string 2nd string remains same. (i+1, j)
         * (i am taking i, j-1 because ideally adding in one can also be imagined as deleting from the other).
         * 
         * 2. we can delete one character from the first string to match the 2nd string (i-1, j).
         * 
         * 3. Replace operation 
         * 
         * now all the 3 operations above will be associated with a cost in this case i am taking it as 1
         * as i am taking the one which is the min of the 3 so adding 1 to it i.e its cost.
         */
        
        return Math.min(Math.min(minEdits(str1, str2, i, j - 1), minEdits(str1, str2, i-1, j)), minEdits(str1, str2, i-1, j-1) ) + 1;
        
    }
}
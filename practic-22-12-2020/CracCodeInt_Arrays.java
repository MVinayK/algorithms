import java.util.*;

class CracCodeInt_Arrays {

    public static void main(String[] args) {
        String inputToIsUnique = "ancjedz";
        //System.out.println(isUnique(inputToIsUnique));
        //System.out.println(isUniqueBitVector(inputToIsUnique));
        //System.out.println(isPermutation("vinay", "yaniv"));

        ispalindromePermutation("vinayvyinnnaxvt");
    }

    /**
     * I am about to check if the sting inside has unique characters 
     */
    private static boolean isUnique(String testStr) {
        boolean[] chars = new boolean[128];
        if(testStr == null || testStr.length() == 0 || testStr.length() > 128) {
            System.out.println("No Dups found");
            return false;
        }
        for(int i= 0; i < testStr.length(); i++) {
            if(chars[(int) testStr.charAt(i) - 97]) {
                System.out.println("Dup found"); 
                return false;       
            } else {
                chars[(int) testStr.charAt(i) - 97] = true; 
            }
        }
        System.out.println("No Dups found");
        return true;
    }

    /**
     * I am about to check if the sting inside has unique characters with 
     */
    private static boolean isUniqueBitVector(String testStr) {
        int checker = 0;
        if(testStr == null || testStr.length() == 0 || testStr.length() > 128) {
            System.out.println("No Dups found");
            return false;
        }

        for(int i= 0; i < testStr.length(); i++) {
            int val = (int) testStr.charAt(i) - 97;
            if( (checker & (1 << val)) > 0 ) { //0100 & 0010 = 0000 and 0100 & 0100 = 0100 which is greater than 1
                System.out.println("Dup found"); 
                return false;       
            } else {
                checker |= 1 << val;  
            }
        }
        System.out.println("No Dups found");
        return true;
    }

    /**
     * Check if in given 2 strings first is the permutation of the second
     * bacic method
     */
    private static boolean isPermutation(String first, String second) {
        //below two declarations are space consuming
        //int[] firstChars = new int[128];
        //int[] secondChars = new int[128];
        //efficient space
        int[] charCounts = new int[128];
        if(first == null || second == null || first.length() != second.length()) {
            System.out.println("Not permutation");
            return false;
        }


        for(int i= 0; i < first.length(); i++) {
            int valFirst = (int) first.charAt(i) - 97;
            charCounts[valFirst]++;
        }

        for(int i= 0; i < second.length(); i++) {
            int valSecond = (int) second.charAt(i) - 97;
            charCounts[valSecond]--;
            if(charCounts[valSecond] < 0) {
                System.out.println("Not permutation");
                return false;
            }
        }
        System.out.println("Permutation");
        return true;
    }

    /**
     * Check if a given string is a permutation of a palindrome string
     */
    private static boolean ispalindromePermutation(String testStr) {

        int[] charCount = getCharCountIntArray(testStr);
        boolean onceOdd = false;
        for(int i = 0; i < charCount.length; i++) {
            
            if(charCount[i] != 0 && charCount[i] % 2 == 1){
                if(onceOdd) {
                    System.out.println("Not a palindrome permutation.");
                    return false;
                }
                onceOdd = true;
            }
        }
        System.out.println("Palindrome permutation");
        return true;
    }

    /**
     * More efficient way to determine a palindrome permutation
     */
    private static boolean ispalindromePermutationEfficient(String testStr) {
        int[] charCount = getCharCountIntArray(testStr);
        boolean onceOdd = false;
        for(int i = 0; i < charCount.length; i++) {
            
            if(charCount[i] != 0 && charCount[i] % 2 == 1){
                if(onceOdd) {
                    System.out.println("Not a palindrome permutation.");
                    return false;
                }
                onceOdd = true;
            }
        }
        System.out.println("Palindrome permutation");
        return true;
    }

    private static int[] getCharCountIntArray(String testStr) {
        int[] charCount = new int[26];
        for(char ch : testStr.toCharArray()) {
            int val = ch - 'a';
            charCount[val]++;
        }
        return charCount;
    }
}
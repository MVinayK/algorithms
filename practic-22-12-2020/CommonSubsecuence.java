import java.util.*;

class CommonSubsecuence {

    public static void main(String arr[]) {

        String a = "AGGTABXD";
        String b = "GXTXAYBDX";
        System.out.println(longestCommonSubSequence(a, b, 0, 0));
        System.out.println(longestCommonSubSequenceMemo(a, b, 0, 0, new HashMap<String, Integer>()));
        System.out.println(longestCommonSubSequenceDyna(a, b));

        String a1 = "AAABBCC";
        String b1 = "AAABBCC";
        System.out.println("*************findLCSWithoutSameIndex***************");
        System.out.println(findLCSWithoutSameIndex(a1, b1));
    }

    private static int longestCommonSubSequence(String a, String b, int posA, int posB) {

        if(posA >= a.length() || posB >= b.length()) {
            return 0;
        }

        if(a.charAt(posA) == b.charAt(posB)) {
            return 1 + longestCommonSubSequence(a, b, posA+1, posB + 1);
        }

        return Math.max(longestCommonSubSequence(a, b, posA, posB + 1), longestCommonSubSequence(a, b, posA+1, posB));

    }

    private static int longestCommonSubSequenceMemo(String a, String b, int posA, int posB, Map<String, Integer> memo) {

        if(posA >= a.length() || posB >= b.length()) {
            return 0;
        }

        String key = posA + "-" + posB;

        if(memo.get(key) != null) {
            return memo.get(key);
        }

        if(a.charAt(posA) == b.charAt(posB)) {
            memo.put(key, 1 + longestCommonSubSequence(a, b, posA+1, posB + 1));
        }

        memo.put(key, Math.max(longestCommonSubSequence(a, b, posA, posB + 1), longestCommonSubSequence(a, b, posA+1, posB)));

        return memo.get(key);
    }

    private static int longestCommonSubSequenceDyna(String a, String b) {

        int[][] dyna = new int[a.length() + 1][b.length() + 1];

        for(int i = 0; i <= a.length(); i++) {
            for(int j = 0; j <= b.length(); j++) {

                if(i == 0 || j == 0) {
                    dyna[i][j] = 0; 
                } else {
                    //else condition is very very important in tabular method as ot garuntees overflow or underflow
                    if(a.charAt(i-1) == b.charAt(j-1)) {
                        dyna[i][j] = 1 + dyna[i-1][j-1];
                    } else {
                        dyna[i][j] = Math.max(dyna[i-1][j], dyna[i][j-1]);
                    }
                }
            }
        }

        return dyna[a.length()][b.length()];
    }

    private static int findLCSWithoutSameIndex(String a, String b) {

        int[][] dyna = new int[a.length() + 1][b.length() + 1];
        
        for(int i = 0; i <= a.length() ;i++) {

            for(int j = 0; j <= b.length(); j++) {

                if(i == 0 || j == 0) {
                    dyna[i][j] = 0;
                } else {

                    if(a.charAt(i-1) == b.charAt(j-1) && i != j) {
                        dyna[i][j] = 1 + dyna[i-1][j-1];
                    } else {
                        dyna[i][j] = Math.max(dyna[i-1][j], dyna[i][j-1]);
                    }
                }
            }
        }

        return dyna[a.length()][b.length()];

    }

}
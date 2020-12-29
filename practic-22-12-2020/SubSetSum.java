import java.util.*;

class SubSetSum {


    public static void main(String arr[]) {
        int[] allSet = new int[]{1, 1, 4, 2, 3};
        //System.out.println(subSetSum(allSet, sumIt(allSet), 0, 0));
        //System.out.println(subSetSumDyna(allSet));
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(minOpToZero(allSet, 0, 5, 0, memo));
    }

    /**
     * {1, 1, 4, 2, 3, 5}
     */
    private static int minOpToZero(int[] arr, int pos, int S, int op, Map<String, Integer> memo) {

        if(S == 0) {
            return op;
        }

        String key = String.valueOf(pos) + "-" + String.valueOf(S);

        if(memo.get(key) != null) {
            return memo.get(key);
        }

        if(pos >= arr.length || S < 0) {
            return Integer.MAX_VALUE;
        }

        memo.put(key, Math.min(minOpToZero(arr, pos + 1, S, op, memo), minOpToZero(arr, pos + 1, S - arr[pos], op + 1, memo)));
        return memo.get(key);
    }

    /**
     * This is a very easy recursive solution -- time complexity 2^N
     */
    private static boolean subSetSum(int[] allSet, int totalSum, int currentSum, int pos) {

        if(pos >= allSet.length) {
            return false;
        }

        if(totalSum == currentSum) {
            return true;
        }

        return subSetSum(allSet, totalSum, currentSum, pos+1) 
        || subSetSum(allSet, totalSum - allSet[pos], currentSum + allSet[pos], pos + 1);
        
    }

    /**
     * Dynamic programmig variant of the same 
     */
    private static boolean subSetSumDyna(int[] allSet) {
        int i = 0, j = 0;

        int sum = sumIt(allSet);

        boolean[][] dyna = new boolean[allSet.length+1][sum/2+1];

        for(i = 0; i <= allSet.length ; i++) {
            
            for(j = 0; j <= sum/2 ; j++) {

                if(j == 0 || i == 0) {
                    dyna[i][j] = false;
                } else if(j < allSet[i -1]) {
                    dyna[i][j] = dyna[i-1][j];
                } else if(allSet[i -1] == j) {
                    dyna[i][j] = true;
                }
                else{
                    dyna[i][j] = dyna[i-1][j] || dyna[i-1][j - allSet[i-1]];
                }

            }
        }
        return dyna[allSet.length][sum/2];
    }

    

    private static int sumIt(int[] allSum) {
        int sum = 0;
        if(allSum.length == 0) {
            return sum;
        }
        for(int i = 0; i < allSum.length; i++ ) {
            sum += allSum[i];
        }
        return sum;
    }
}
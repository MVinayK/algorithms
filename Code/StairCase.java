class StairCase {

    /**
     * This approach uses memoization and the time is drastically reduced
     * the time complexity becomes quadratic from exponential
     * @param N
     * @param memo
     * @return
     */

    public int possibleWays(int N, int[] memo) {
        
        if(N <= 0) {
            return 0;
        }

        if(N == 1) {
            return 1;
        }

        if(memo[N] != 0) {
            return memo[N];
        }

        memo[N] = possibleWays(N-3, memo) + possibleWays(N - 2, memo) + possibleWays(N-1, memo); 
        return memo[N];
    }

}
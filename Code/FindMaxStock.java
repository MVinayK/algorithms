
public class FindMaxStock {


    public int findMaxStock(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                dp[i][j] = -1;
            }   
        }
        return findMaxDiff(prices, 0, 0, prices.length-1, dp);
    } 

    private int findMaxDiff(int[] prices, int maxDiff, int start, int end, int[][] dp) {

        if(start >= end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        if(start < end) {
            maxDiff = prices[end] - prices[start];
        }

        dp[start][end] = Math.max(maxDiff, Math.max(findMaxDiff(prices, maxDiff, start + 1, end, dp), 
                                                    findMaxDiff(prices, maxDiff, start, end-1, dp)));

        return dp[start][end];

    }

}
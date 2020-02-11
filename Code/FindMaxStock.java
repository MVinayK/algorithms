
public class FindMaxStock {


    public int findMaxStock(int[] prices) {
        return findMaxDiff(prices, 0, 0, prices.length-1);
    } 

    private int findMaxDiff(int[] prices, int maxDiff, int start, int end) {

        if(start >= end) {
            return 0;
        }

        if(start < end) {
            maxDiff = prices[end] - prices[start];
        }

        return Math.max(maxDiff, Math.max(findMaxDiff(prices, maxDiff, start + 1, end), findMaxDiff(prices, maxDiff, start, end-1)));

    }

}
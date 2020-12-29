class Knapsac {

    public static void main(String[] arr) {
        int[] wt = new int[]{4, 2, 6, 5, 9};
        int[] profits = new int[]{5, 6, 9, 4, 15};
        int bagWt = 15;
        int[][] memo = new int[profits.length + 1][bagWt + 1];
        //int profit = knapsacRecur(wt, profits, bagWt, 0, 0);
        //int profit = knapsacMemo(wt, profits, bagWt, 0, 0, memo);
        int profit = knapsacDynamicProg(wt, profits, bagWt, 0);
        System.out.println(profit);
    }

    private static int knapsacRecur(int[] wt, int[] profit, int bagWt, int pointer, int totalProfit) {

        if(bagWt <= 0 || pointer >= wt.length) {
            return totalProfit;
        }
        
        if(bagWt < wt[pointer]) {
            return totalProfit;
        }

        return Math.max(knapsacRecur(wt, profit, bagWt - wt[pointer], pointer + 1, profit[pointer] + totalProfit), 
            knapsacRecur(wt, profit, bagWt, pointer + 1, totalProfit));

    } 

    
    private static int knapsacMemo(int[] wt, int[] profit, int bagWt, int pointer, int totalProfit, int[][] memo) {

        if(bagWt <= 0 || pointer >= wt.length) {
            return totalProfit;
        }

        if(memo[pointer][bagWt] > 0) {
            return memo[pointer][bagWt];
        }
        
        if(bagWt < wt[pointer]) {
            return memo[pointer][bagWt] = totalProfit;
        }

        return memo[pointer][bagWt] = Math.max(knapsacRecur(wt, profit, bagWt - wt[pointer], pointer + 1, profit[pointer] + totalProfit), 
            knapsacRecur(wt, profit, bagWt, pointer + 1, totalProfit));

    }

    /**
     * Knapsac dynamic programming based approach
     */
    private static int knapsacDynamicProg(int[] wt, int[] profit, int bagWt, int pointer) {

        int[][] dyna = new int[profit.length + 1][bagWt + 1];

        for(int i = 0; i <= profit.length; i++) {

            for(int w = 0; w <= bagWt; w++) {

                if(i == 0 || w == 0) {
                    dyna[i][w] = 0;
                } else if(wt[i - 1] > w) {
                    dyna[i][w] = dyna[i - 1][w];
                } else {
                    dyna[i][w] = Math.max(dyna[i-1][w], profit[i - 1] + dyna[i-1][w - wt[i-1]]);
                }
            }
        }

        return dyna[profit.length][bagWt];

    }

}
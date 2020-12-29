package Code.Code;

import java.util.Arrays;

public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[coins.length + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++) {

            for(int j = 0; j < coins.length; j++) {

                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else {
                    break;
                }

            }

        }


        return dp[coins.length];
    }

}
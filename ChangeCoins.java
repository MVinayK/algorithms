import java.util.Arrays;

public class ChangeCoins {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[coins.length + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++) {

            for(int j = 0; j < coins.length; j++) {

                if(coins[j] <= amount) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else {
                    break;
                }

            }

        }


        return dp[coins.length];
    }
}
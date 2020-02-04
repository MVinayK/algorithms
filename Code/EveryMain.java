import java.util.ArrayList;

/**
 * EveryMain
 */
public class EveryMain {


    public static void main(String[] arr) {
        
        /*StairCase stairCase = new StairCase();
        int res = stairCase.possibleWays(1000, new int[1001]);
        System.out.println(res); */

        //EggDropping eggDrop = new EggDropping();
        //eggDrop.calculateNofWays(25, 5);
        
        LongestPalindrome palin = new LongestPalindrome();

        int len = palin.findLongestPalindrome("acnamana");
        System.out.println(len);

    }
}
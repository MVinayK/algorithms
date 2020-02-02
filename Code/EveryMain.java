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
        
        Solution sol = new Solution();
        ArrayList<Integer> list = sol.getRow(2);
        list.stream().forEach(System.out::print);

    }
}
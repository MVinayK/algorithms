import java.util.stream.IntStream;

/**
 * EveryMain
 */
public class EveryMain {


    public static void main(String[] arr) throws Exception {
        
        /*StairCase stairCase = new StairCase();
        int res = stairCase.possibleWays(1000, new int[1001]);
        System.out.println(res); */

        //EggDropping eggDrop = new EggDropping();
        //eggDrop.calculateNofWays(25, 5);
        
        //LongestPalindrome palin = new LongestPalindrome();
        //int len = palin.findLongestPalindrome("acnamana");
        //System.out.println(len);

        //BSTPreOrder preOrder = new BSTPreOrder();
        //Node root = preOrder.buildTreeWithPreOrder(new int[]{10, 5, 1, 7, 40, 50});
        //TreeUtil.inOrderPrint(root);
        //System.out.println("Height of the tree : " + TreeUtil.height(root));

        //TreeUtil.traverseLevelOrder(root, null);

        //FindMaxStock st = new FindMaxStock();
        //int max = st.findMaxStock(new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97});
        //System.out.println(max);

        PushZeroToEnd pZeroToEnd = new PushZeroToEnd();
        int[] ans = pZeroToEnd.pushZeroToEnd(new int[]{100, 113, 0, 0, 0, 110, 85, 105, 0, 0, 102, 86, 63, 81, 0, 0});

        IntStream.range(0, ans.length).forEach(e -> {
            System.out.print(ans[e] + " ");
        });

    }
}
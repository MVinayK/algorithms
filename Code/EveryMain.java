
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

        BSTPreOrder preOrder = new BSTPreOrder();
        Node root = preOrder.buildTreeWithPreOrder(new int[]{10, 5, 1, 7, 40, 50});
        //TreeUtil.inOrderPrint(root);
        System.out.println("Height of the tree : " + TreeUtil.height(root));

        TreeUtil.traverseLevelOrder(root, null);

    }
}
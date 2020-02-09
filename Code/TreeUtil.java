
public class TreeUtil {

    public static void inOrderPrint(Node root) {
        if(root != null) {
            inOrderPrint(root.left);
            System.out.println(root.data);
            inOrderPrint(root.right);
        }
    }

    public static int height(Node root) {
        if(root == null) 
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void traverseLevelOrder(Node root, Boolean topDown) {
        topDown = topDown == null ? true : topDown;
        int levels = height(root);

        if(topDown) {
            for(int i = 1 ; i <= levels; i++) {
                printLevels(root, i);
                System.out.println();
            }
        } else {
            for(int i = levels ; i >= 1; i--) {
                printLevels(root, i);
                System.out.println();
            }
        }
    }

    private static void printLevels(Node root, int level) {
        if(root == null) 
            return;
        if(level == 1) 
            System.out.print(root.data + " ");

        printLevels(root.left, level - 1);
        printLevels(root.right, level - 1);
    }
}
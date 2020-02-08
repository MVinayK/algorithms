
public class TreeUtil {

    public static void inOrderPrint(Node root) {
        if(root != null) {
            inOrderPrint(root.left);
            System.out.println(root.data);
            inOrderPrint(root.right);
        }
    }
}
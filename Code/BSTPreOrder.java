
public class BSTPreOrder {

    public Node buildTreeWithPreOrder(int[] preOrder) throws Exception {
        int[] inOrder = new int[preOrder.length];
        for(int k = 0; k < preOrder.length ;k++) {
            inOrder[k] = preOrder[k];
        }
        inOrder = getInOrder(inOrder);
      
        return buildPre(preOrder, 0, 0, preOrder.length -1 , inOrder);
    }

    private Node buildPre(int[] preOrder, int preindex, int start, int end, int[] inOrder) {

        if(preindex > preOrder.length - 1 || start > end || start > preOrder.length - 1) {
            return null;
        }

        Node root = new Node(preOrder[preindex]);
        int index = 0;

        for(index = 0; index  < inOrder.length ; index++) {
            if(inOrder[index] == root.data) {
                break;
            }
        }
        /**
         * Why ? ->  index - start + 1
         * ideally we are substracting the no of items which will be there in the 
         * left sub tree , because always in preorder traversal first left half will appear
         * so eliminating the left half elements the first element will be the root of the 
         * right half hence last elemnet - fist element (index - start) '+1' for locating the 
         * root 
         */
        root.left = buildPre(preOrder, preindex + 1, start, index - 1, inOrder);
        root.right = buildPre(preOrder, preindex + index - start + 1, index + 1, end, inOrder);

        return root;
    }

    private int[] getInOrder(int[] preOrder) throws Exception {
        if(preOrder.length == 0) {
            throw new Exception("pre order array is empty !!!");
        }
        for(int i=0; i < preOrder.length ; i++) {
            for(int j=0; j < preOrder.length ; j++) {
                if(preOrder[i] < preOrder[j] ) {
                    int temp = preOrder[i];
                    preOrder[i] = preOrder[j];
                    preOrder[j] = temp; 
                }
            }   
        }

        return preOrder;
    }
}
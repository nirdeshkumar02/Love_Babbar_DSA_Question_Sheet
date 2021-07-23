package Binary_Trees;

public class Create_Binary_Tree_From_Inorder_and_Preorder {
    public static void main(String[] args){
        BinaryTree BT = new BinaryTree();
        Solution s = new Solution();
        Node root2 = null;
        Node2 root = null;
        int[] preorderArray = {2, 4, 7, 3, 8};
        int[] inorderArray = {7, 4, 3, 2, 8};
        root = BT.createTree(preorderArray, inorderArray, 0, inorderArray.length-1);
        System.out.println("\nBinary Tree case 1");
        BT.postorder(root);

        root2 = s.buildBinaryTree(preorderArray, inorderArray, inorderArray.length);
        System.out.println("\nBinary Tree case 2");
        s.postorder(root2);
    }
}

class BinaryTree{

    static int preIndex;
    public Node2 createTree(int[] preorderArray, int[] inorderArray, int start, int end) {
        if(start > end) return null;
        Node2 node = createNewNode(preorderArray[preIndex++]);
        if(start == end) return node;
        int inorderIndex = getInorderIndex(node.data, inorderArray, start, end);
        node.left = createTree(preorderArray, inorderArray, start, inorderIndex-1);
        node.right = createTree(preorderArray, inorderArray, inorderIndex+1, end);
        return node;
    }

    private int getInorderIndex(int data, int[] inorderArray, int start, int end) {
        for(int i = start; i<=end; i++){
            if(inorderArray[i] == data){
                return i;
            }
        }
        return -1;
    }

    public Node2 createNewNode(int val) {
        Node2 newNode = new Node2();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public void postorder(Node2 root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
        }
    }
class Node2 {
    Node2 left;
    Node2 right;
    int data;
}

// ----------------------------------------- 2nd solution ------------------- //

class Solution{
    int preIndex = 0;
    public Node buildBinaryTree(int[] preorderArray, int[] inorderArray, int n) {
        preIndex = 0;
        return create(preorderArray, inorderArray, 0, n-1);
    }

    private Node create(int[] preorderArray, int[] inorderArray, int start, int end) {
        if(start > end) return null;
        Node root = new Node(preorderArray[preIndex++]);
        int inorderIndex = -1;
        for(int i = start; i<=end; i++){
            if(inorderArray[i] == root.data){
                inorderIndex = i;
                break;
            }
        }
        root.left = create(preorderArray, inorderArray, start, inorderIndex-1);
        root.right = create(preorderArray, inorderArray, inorderIndex+1, end);
        return root;
    }

    public void postorder(Node root2) {
        if(root2 == null) return;
        postorder(root2.left);
        postorder(root2.right);
        System.out.print(root2.data + " ");
    }
}




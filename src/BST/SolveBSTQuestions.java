package BST;

import java.util.*;

/**
 * https://leetcode.com/tag/binary-search-tree/
 * https://practice.geeksforgeeks.org/explore/?category%5B%5D=Binary%20Search%20Tree&page=1&category%5B%5D=Binary%20Search%20Tree
 *
 * Questions:
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */

public class SolveBSTQuestions extends BST {
    // solve here
//    public static int max(Node root){
//        if(root == null){
//            return 0;
//        }
//        if(root.right != null){
//            return max(root.right);
//        }
//        else{
//            return root.val;
//        }
//    }
//    public static Node deleteNode(Node root, int key) {
//        if(root == null){
//            return null;
//        }
//
//        if(key > root.val){
//            root.right = deleteNode(root.right, key);
//        }
//        else if(key < root.val){
//            root.left = deleteNode(root.left, key);
//        }
//        else {
//            // main code
//
//            if(root.right != null && root.left != null){
//                int left_max = max(root.left);
//                root.data = left_max;
//                root.left = deleteNode(root.left, left_max);
//            }
//            else if(root.right != null){
//                return root.right;
//            }
//            else if(root.left != null){
//                return root.left;
//            }
//            else {
//                return null;
//            }
//        }
//        return root;
//    }
    // do it first
    //https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    public static List<Integer> pre_order1(Node root) {

        List<Integer> list = new ArrayList<>();

        // base case
        if (root == null) {
            return list;
        }

        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            list.add(temp.data);

            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }

        return list;
    }

    // https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    public static void getAllElements(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>(pre_order1(root1));
        List<Integer> list2 = new ArrayList<>(pre_order1(root2));

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);

        Arrays.sort(list.toArray());

        System.out.println(Arrays.toString(list.toArray()));
    }

    // check for BST or not
    static Node prev = null;
    static boolean isBST(Node root){
        if(root != null){
            if(!isBST(root.left)){
                return false;
            }
            if(prev != null && root.data <= prev.data){
                return false;
            }

            prev = root;
            return isBST(root.right);
        }
        return true;
    }


    /*static ArrayList<Integer> list_arr = new ArrayList<>();
    public static void inorder(Node node){
        if(node.left != null){
            inorder(node.left);
        }
        list_arr.add(node.data);
        if(node.right != null){
            inorder(node.right);
        }
    }

    public int kthSmallest(Node root, int k) {
        inorder(root);
        return list_arr.get(k);
    }*/

    static ArrayList<Integer> list_arr = new ArrayList<>();
    public static ArrayList<Integer> inorder(Node node){
        if(node == null){
            return list_arr;
        }
        if(node.left != null){
            inorder(node.left);
        }
        list_arr.add(node.data);
        if(node.right != null){
            inorder(node.right);
        }

        return list_arr;
    }

    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> list;
        list = inorder(root);
        return list.get(k-1);
    }

    public Node trimBST(Node root, int low, int high) {

        if(root == null){
            return null;
        }
        // if the val < low so the tree on the right side
        if(root.data < low){
            return trimBST(root.right, low, high);
        }
        // if the val > high so the tree on the left side
        if(root.data > high){
            return trimBST(root.left, low, high);
        }
        // updating the result
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    // Level Order Traversal
    /**
     * using Queue
     * add root to queue first then
     * remove 1 ele then, add left and right child of the removed ele
     * @param root
     */
    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.print(cur.data + " ");

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }

    public static void levelOrderTraversal_ln(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null); // just adding null end of the queue

        while (!q.isEmpty()){
            Node cur = q.remove();
            // checking if cur null or not, if null sending it to end of the queue
            if(cur == null){
                if(q.isEmpty()){
                    return;
                }
                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(cur.data + " ");

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }

    // main method
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(5);

        insertNode(tree.root, 1);
        insertNode(tree.root, 7);
        insertNode(tree.root, 2);
        insertNode(tree.root, 4);
        insertNode(tree.root, 3);
        insertNode(tree.root, 6);

        levelOrderTraversal(tree.root);
        System.out.println("\nIn level wise print");
        levelOrderTraversal_ln(tree.root);
    }
}

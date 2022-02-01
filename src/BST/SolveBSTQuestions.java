package BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/tag/binary-search-tree/
 * https://practice.geeksforgeeks.org/explore/?category%5B%5D=Binary%20Search%20Tree&page=1&category%5B%5D=Binary%20Search%20Tree
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

    // main method
    public static void main(String[] args) {
//        BST bst = new BST();

        BST root1 = new BST();
        root1.root = new Node(2);
        root1.root.left = new Node(1);
        root1.root.right = new Node(4);

        BST root2 = new BST();
        root2.root = new Node(1);
        root2.root.left = new Node(0);
        root2.root.right = new Node(3);

        getAllElements(root1.root, root2.root);
        //.out.println(pre_order1(root1.root));
        //System.out.println(pre_order1(root2.root));

    }
}

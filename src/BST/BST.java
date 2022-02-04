package BST;

import java.util.Stack;

class Node{
    int data;
    Node left, right;
    Node root;

    Node(int value){
        this.data = value;
        this.left = null;
        this.right = null;
    }

    Node(){
        this.left = null;
        this.right = null;
    }
}

public class BST extends Node{
    BST(){
        // default constructor
        //root = null;
    }

    public static Node search(Node root, int key){
        // base case
        if(root == null){
            return null;
        }

        if(root.data == key){
            return root;
        }

        if(root.data < key){
            return search(root.right, key);
        }
        else{
            return search(root.left, key);
        }
    }

    public static Node insertNode(Node root, int key){

        Node node = new Node(key);
        Node parent_node = null;
        Node current_node = root;

        //base case
        if(root == null){
            root = node;
            return root;
        }

        while (current_node != null){
            parent_node = current_node;
            if(node.data < current_node.data){
                current_node = current_node.left;
            }
            else{
                current_node = current_node.right;
            }
        }

        if(node.data < parent_node.data){
           //return insertNode(parent_node.left, key);
            parent_node.left = node;
        }
        else{
            //return insertNode(parent_node.right, key);
            parent_node.right = node;
        }

        return root;
    }

    // Insertion in BST using recursion
    public static Node insertRe(Node root, int key){
        Node node = new Node(key);
        // base case
        if(root == null){
            root = node;
            return root;
        }

        if(root.data == node.data){
            return root;
        }

        if(node.data < root.data){
            root.left = insertRe(root.left, key);
        }
        else {
            root.right = insertRe(root.right, key);
        }
        return root;
    }

    // Root, left, right
    public static void preOrder(Node node){
        System.out.print(node.data + " ");
        if(node.left != null){
            preOrder(node.left);
        }
        if(node.right != null){
            preOrder(node.right);
        }
    }

    // left, right, root
    public static void postOrder(Node node){
        if(node.left != null){
            postOrder(node.left);
        }
        if(node.right != null){
            postOrder(node.right);
        }
        System.out.print(node.data + " ");
    }

    // left, root, right
    public static void inOrder(Node node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right != null){
            inOrder(node.right);
        }
    }

    // delete a node from BST
    public static int max(Node node){
        if(node == null){
            return 0;
        }
        if(node.right != null){ // this will find the max element of the node's left side
           return max(node.right);
        }
        else {
            return node.data; // this will return max value element
        }
    }

    public static Node deleteNode(Node node, int key){
        if(node == null){
            return null;
        }

        if(key > node.data){
            node.right = deleteNode(node.right, key);
        }
        else if(key < node.data){
            node.left = deleteNode(node.left, key);
        }
        else{
            // main working code start here (when node have 2 child, or 1 child)
            // we are deleting the node and replacing with the left side max value
            if(node.left != null && node.right != null){
                int left_max = max(node.left);
                node.data = left_max;
                node.left = deleteNode(node.left, left_max);
            }
            else if(node.left != null){
                return node.left;
            }
            else if(node.right != null){
                return node.right;
            }
            else {
                return null;
            }
        }

        return node;
    }

    // Traversing of BST using iterative way
    // preOrder using stack (Big O(n))
    public static void pre_order(Node root){
        // base case
        if(root == null){
            return;
        }

        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while (!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data + " ");

            if(temp.right != null){
                st.push(temp.right);
            }
            if(temp.left != null){
                st.push(temp.left);
            }
        }
    }

    public static void post_order(Node root){
        // using two stack
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        //base case
        if(root == null){
            return;
        }

        s1.push(root);

        while (!s1.isEmpty()){
            Node temp = s1.pop();
            s2.push(temp);

            if(temp.left != null){
                s1.push(temp.left);
            }
            if(temp.right != null){
                s1.push(temp.right);
            }
        }
        while (!s2.isEmpty()){
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }

    public static void post_order_oneStack(Node root){
        // using one stack
        Stack<Node> st = new Stack<Node>();
        while (true){
            while (root != null){
                st.push(root);
                st.push(root);
                root = root.left;
            }

            if(st.isEmpty()) {
                return;
            }
            root = st.pop();

            if(!st.isEmpty() && st.peek() == root){
                root = root.right;
            }
            else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }

    public static void in_order(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new Node(10);
        bst.root.left = new Node(9);
        bst.root.right = new Node(30);

        insertNode(bst.root, 15);
        insertRe(bst.root, 5);

        insertNode(bst.root, 2);
        insertNode(bst.root, 8);
        insertNode(bst.root, 40);

        System.out.print("Pre order : ");
        preOrder(bst.root);
        System.out.println();

        System.out.print("Post order : ");
        postOrder(bst.root);
//
//        System.out.println();
//        System.out.print("In order : ");
//        inOrder(bst.root);

        System.out.println();
        deleteNode(bst.root, 15);
        System.out.print("Pre order : ");
        preOrder(bst.root);
        System.out.println();


        System.out.println("BST preorder in iterative way: ");
        pre_order(bst.root);

        System.out.println();
        post_order(bst.root);

        System.out.println();
        post_order_oneStack(bst.root);

        System.out.println("\nIn order iterative way");
        in_order(bst.root);

    }


    /*public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new Node(1);
        bst.root.left = new Node(2);
        bst.root.right = new Node(3);
        bst.root.left.left = new Node(4);
        bst.root.left.right = new Node(5);

//        insertRe(bst.root, 4);
//        insertRe(bst.root, 5);

        in_order(bst.root);
    }*/
}
package BST;

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

        System.out.println();
        System.out.print("In order : ");
        inOrder(bst.root);

    }
}
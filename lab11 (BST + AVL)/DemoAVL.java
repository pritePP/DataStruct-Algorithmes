import java.util.Scanner;
public class DemoAVL{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Create a scanner to read input
    AVLTree tree = new AVLTree();
    System.out.println("Enter 7 integers to insert into the AVL tree:");
    for (int i = 0; i < 7; i++) {
        System.out.print("Enter value " + (i + 1) + ": ");
        int value = scanner.nextInt(); // Read an integer value from user
        tree.root = tree.insert(tree.root, value); // Insert value into AVL tree
    }
    /* Constructing tree given in the above figure */      /*Task4
   /* tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 20);
    tree.root = tree.insert(tree.root, 30);
    tree.root = tree.insert(tree.root, 40);
    tree.root = tree.insert(tree.root, 50);
    tree.root = tree.insert(tree.root, 25);
    tree.root = tree.insert(tree.root, 70);
    tree.root = tree.insert(tree.root, 15);
    tree.root = tree.insert(tree.root, 45);*/
    System.out.println("++Preorder traversal++");
    tree.preOrder(tree.root);
    System.out.println("\n++Inorder traversal++");
    //tree.inOrder(tree.root);
    System.out.println("\n++Postorder traversal++");
    //tree.postOrder(tree.root);S

    System.out.println("\nHeight = "+ tree.height(tree.root));
    }
    }
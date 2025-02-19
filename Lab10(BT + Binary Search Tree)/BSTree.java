import java.util.Scanner;

public class BSTree {
    // โครงสร้างของ Node
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // ฟังก์ชันการแทรกข้อมูล
    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    // In-order Traversal
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.value);
            inOrder(node.right);
        }
    }

    // Pre-order Traversal
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order Traversal
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);  // สร้าง Scanner สำหรับรับค่า
        BSTree tree = new BSTree();

        // รับค่าจากผู้ใช้ 8 ตัว
        System.out.println("Please Enter 8 Number to build to tree:");
        int[] values = new int[8];  // อาเรย์เก็บค่าที่ผู้ใช้กรอก
        for (int i = 0; i < 8; i++) {
            System.out.print("input number " + (i + 1) + ": ");
            values[i] = sc.nextInt();
        }

        // สร้างต้นไม้ด้วยค่าที่รับเข้ามา
        Node root = new Node(values[0]); // กำหนดรากของต้นไม้เป็นค่าตัวแรก
        for (int i = 1; i < 8; i++) {
            tree.insert(root, values[i]); // แทรกค่าที่เหลือลงในต้นไม้
        }

        // แสดงผลการท่องต้นไม้
        System.out.println("+++ In-order Traversal +++");
        tree.inOrder(root);
        System.out.println();  // ขึ้นบรรทัดใหม่

        System.out.println("+++ Pre-order Traversal +++");
        tree.preOrder(root);
        System.out.println();  // ขึ้นบรรทัดใหม่

        System.out.println("+++ Post-order Traversal +++");
        tree.postOrder(root);
        System.out.println();  // ขึ้นบรรทัดใหม่

        sc.close();  // ปิด scanner
    }
}

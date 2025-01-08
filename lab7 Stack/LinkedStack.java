public class LinkedStack {
    int size;
    LinkedNode root;

    class LinkedNode {
        Object element;
        LinkedNode next;

        public LinkedNode(Object element, LinkedNode next) {
            this.element = element;
            this.next = next;
        }
    }

    public LinkedStack() {
        size = 0;
        root = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void push(Object obj) {
        LinkedNode node = new LinkedNode(obj, null);
        node.next = root;
        root = node;
        size++;
    }

    public String toString() {
        String ans = "";
        LinkedNode p = root;
        while (p != null) {
            ans = ans + p.element + "  ";
            p = p.next;
        }
        return ans;
    }

    Object peek() {
        if (isEmpty()) {
            System.out.println("no data to peek");
            return null;

        }
        return root.element;

    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("no data to peek");
            return null;
        }
        Object ob = root.element;
        root = root.next;
        size--;
        return ob;
    }
}

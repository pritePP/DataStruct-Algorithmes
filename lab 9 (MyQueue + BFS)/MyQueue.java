public class MyQueue {
    private Object[] elementData;
    private int size;
    private int front;
 
    public MyQueue(int n){
    elementData = new Object[n];
    size = 0;
    front = 0;
    }
 
    public void enqueue(Object obj) {
        if(size < elementData.length) {
            int b = (front + size) % elementData.length;
            elementData[b] = obj ;
            size++;
        }
    }
 
    public Object dequeue() {
        Object obj = elementData[front];
        elementData[front] = null;
        front++;
        size--;
        return obj;
    }
 
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
 
    public String toString() {
        String ans = "[";
        for (int i = 0; i <= size; i ++) {
 
            ans += elementData[(front+i)%elementData.length];
            if (i < size-1) ans += " ";
        }
        ans += "]";
        return ans;
    }
}// MyQueue
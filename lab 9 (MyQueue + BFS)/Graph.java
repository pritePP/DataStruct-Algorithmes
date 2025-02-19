import java.io.*;
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i <=5; ++i)
            adj[i] = new LinkedList();

    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default - set as false)
        boolean visited[] = new boolean[V];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 8);
        g.addEdge(1, 0);
        g.addEdge(1, 7);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(3, 0);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 8);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
        g.addEdge(7, 1);
        g.addEdge(7, 2);
        g.addEdge(8, 0);
        g.addEdge(8, 4);
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);

    }
}
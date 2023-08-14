package Day270;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int w : adj[i]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s) {
        boolean[] seen = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        seen[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj[u]) {
                if (!seen[v]) {
                    q.offer(v);
                    seen[v] = true;
                }
            }
        }
    }

    public void dfs(int s) {
        boolean[] seen = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!seen[u]) {
                System.out.print(u + " ");
                seen[u] = true;
                for (int v : adj[u]) {
                    if (!seen[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        System.out.println(g);
        g.bfs(0);
        System.out.println();
        g.dfs(0);

    }
}

package Day272;

import java.util.LinkedList;

public class Graph {

    private LinkedList<Integer>[] adjList;
    private int V;
    private int E;

    public Graph(int nodes) {
        V = nodes;
        E = 0;
        adjList = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adjList[u].add(v);
        this.adjList[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int w : adjList[i]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void dfs() {
        boolean[] visited = new boolean[V];
        int[] compId = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, compId, count);
                count++;
            }
        }
    }
    public void dfs(int v, boolean[] visited, int[] compId, int count) {
        visited[v] = true;
        System.out.print(v + " ");
        compId[v] = count;
        for (int w : adjList[v]) {
            if (!visited[w]) {
                dfs(w, visited, compId, count);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.dfs();
    }
}

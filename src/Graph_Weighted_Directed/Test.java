package Graph_Weighted_Directed;

public class Test {
    public static void main(String[] args) {
        Edge_Weighted_Graph graph = new Edge_Weighted_Graph(8);
        graph.addEdge(new Edge_Directed(0,2,0.26));
        graph.addEdge(new Edge_Directed(0,4,0.38));
        graph.addEdge(new Edge_Directed(1,3,0.31));
        graph.addEdge(new Edge_Directed(2,7,0.34));
        graph.addEdge(new Edge_Directed(3,6,0.52));
        graph.addEdge(new Edge_Directed(4,5,0.35));
        graph.addEdge(new Edge_Directed(4,7,0.25));
        graph.addEdge(new Edge_Directed(5,1,0.32));
        graph.addEdge(new Edge_Directed(5,7,0.31));
        graph.addEdge(new Edge_Directed(6,0,0.31));
        graph.addEdge(new Edge_Directed(6,2,0.11));
        graph.addEdge(new Edge_Directed(6,4,0.12));
        graph.addEdge(new Edge_Directed(7,3,0.39));
        graph.addEdge(new Edge_Directed(7,5,0.2));

        Dijkstra d   = new Dijkstra(graph,0);
        System.out.println(d.pathTo(7));
    }
}

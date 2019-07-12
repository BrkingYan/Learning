package Graph_Weighted;

public class Test {
    public static void main(String[] args) {
        Edge_Weighted_Graph graph = new Edge_Weighted_Graph(8);
        graph.addEdge(new Edge(0,2,0.26));
        graph.addEdge(new Edge(0,4,0.38));
        graph.addEdge(new Edge(0,6,0.58));
        graph.addEdge(new Edge(0,7,0.16));

        graph.addEdge(new Edge(1,3,0.29));
        graph.addEdge(new Edge(1,2,0.36));
        graph.addEdge(new Edge(1,5,0.32));
        graph.addEdge(new Edge(1,7,0.19));

        graph.addEdge(new Edge(2,3,0.17));
        graph.addEdge(new Edge(2,6,0.40));
        graph.addEdge(new Edge(2,7,0.34));

        graph.addEdge(new Edge(3,6,0.52));

        graph.addEdge(new Edge(4,5,0.35));
        graph.addEdge(new Edge(4,6,0.93));
        graph.addEdge(new Edge(4,7,0.37));

        graph.addEdge(new Edge(5,7,0.28));

        /************************** lazy prim Test ******************************/
        System.out.println("************************** lazy prim Test ******************************");
        PrimMST_Lazy lazyMST = new PrimMST_Lazy(graph);
        System.out.println(lazyMST.edges());

        /************************** prim Test ******************************/
        System.out.println("************************** prim Test ******************************");
        PrimMST prim = new PrimMST(graph);
        System.out.println(prim.edges());

        /************************** Kruskal Test ******************************/
        System.out.println("************************** Kruskal Test **********************");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal.getMst());
    }
}

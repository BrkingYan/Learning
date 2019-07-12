package Graph_Directed;

import edu.princeton.cs.algs4.Bag;

public class MyGraph {
    private final int num_vertex;
    private int num_edges;
    private Bag<Integer>[] neighborsArray;

    public MyGraph(int vertexNum){
        num_vertex = vertexNum;
        num_edges = 0;
        neighborsArray = (Bag<Integer>[]) new Bag[num_vertex];
        for (int i = 0;i<num_vertex;i++){
            neighborsArray[i] = new Bag<>();
        }
    }

    public int numOfVertex(){
        return num_vertex;
    }

    public int numOfEdges(){
        return num_edges;
    }

    public void addEdge(int src,int dest){
        neighborsArray[src].add(dest);
        num_edges++;
    }

    public Bag<Integer> getNeighbors(int v){
        return neighborsArray[v];
    }

    public MyGraph reverse(){
        MyGraph reversedGraph = new MyGraph(num_vertex);
        for (int i = 0;i<num_vertex;i++){
            for (int v : neighborsArray[i]){
                reversedGraph.addEdge(v,i);
            }
        }
        return reversedGraph;
    }

    public int getNum_vertex(){
        return num_vertex;
    }

    public int getNum_edges(){
        return num_edges;
    }

}

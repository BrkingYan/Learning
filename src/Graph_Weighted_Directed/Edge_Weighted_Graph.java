package Graph_Weighted_Directed;


import edu.princeton.cs.algs4.Bag;

import java.util.LinkedList;

public class Edge_Weighted_Graph {
    private final int num_vertex;
    private int num_edge;
    private Bag<Edge_Directed>[] neibourArray;

    public Edge_Weighted_Graph(int num_vertex){
        this.num_vertex = num_vertex;
        neibourArray = (Bag<Edge_Directed>[]) new Bag[num_vertex];

        for (int i = 0;i<num_vertex;i++){
            neibourArray[i] = new Bag<>();
        }
    }

    public void addEdge(Edge_Directed edge){
        neibourArray[edge.startNode()].add(edge);
        num_edge++;
    }

    public Iterable<Edge_Directed> getAdjBag(int v){
        return neibourArray[v];
    }

    public Iterable<Edge_Directed> edges(){
        LinkedList<Edge_Directed> list = new LinkedList<>();
        for (int v = 0;v < num_vertex;v++){
            for (Edge_Directed e : neibourArray[v]){
                list.add(e);
            }
        }
        return list;
    }

    public int getNum_vertex() {
        return num_vertex;
    }

    public int getNum_edge() {
        return num_edge;
    }
}

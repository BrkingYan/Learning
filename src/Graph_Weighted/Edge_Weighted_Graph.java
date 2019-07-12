package Graph_Weighted;


import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;

/*
* 加权无向图
* */
public class Edge_Weighted_Graph {
    private final int num_vertex;
    private int num_edges;
    private Bag<Edge>[] neibourArray;

    public Edge_Weighted_Graph(int num_vertex){
        this.num_vertex = num_vertex;
        this.num_edges = 0;
        neibourArray = (Bag<Edge>[]) new Bag[num_vertex];

        for (int i = 0;i<num_vertex;i++){
            neibourArray[i] = new Bag<>();
        }
    }

    public int getNum_vertex(){
        return num_vertex;
    }

    public int getNum_edges(){
        return num_edges;
    }

    public void addEdge(Edge edge){
        int node1 = edge.getOneNode();
        int node2 = edge.getAnother(node1);
        neibourArray[node1].add(edge);
        neibourArray[node2].add(edge);
        num_edges++;
    }

    public Bag<Edge> getAdjBag(int v){
        return neibourArray[v];
    }


    public ArrayList<Edge> edges(){
        ArrayList<Edge> list = new ArrayList<>();
        for (int v = 0;v<num_vertex;v++){
            for (Edge e : getAdjBag(v)){
                if (e.getAnother(v) > v){
                    list.add(e);
                }
            }
        }
        return list;
    }
}

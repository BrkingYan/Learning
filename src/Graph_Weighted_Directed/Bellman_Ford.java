package Graph_Weighted_Directed;


import edu.princeton.cs.algs4.EdgeWeightedDirectedCycle;
import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;

/*
*  Bellman_Ford 算法也是处理最短路径问题，他还能检测负权重环，防止陷入无限循环
* */
public class Bellman_Ford {
    private double[] distanceTo;
    private Edge_Directed[] edgeTo;
    private boolean[] onQueue;
    private LinkedList<Integer> queue;
    private int cost;
    private Iterable<Edge_Directed> cycle;//

    public Bellman_Ford(Edge_Weighted_Graph graph,int start){
        distanceTo = new double[graph.getNum_vertex()];
        edgeTo = new Edge_Directed[graph.getNum_vertex()];
        onQueue = new boolean[graph.getNum_vertex()];
        queue = new LinkedList<>();

        for (int v = 0;v < graph.getNum_vertex();v++){
            distanceTo[v] = Double.POSITIVE_INFINITY;
        }

        queue.add(start);
        onQueue[start] = true;

        while (!queue.isEmpty()  ){
            int v = queue.poll();
            onQueue[v] = false;

        }


    }

    private void relax(Edge_Weighted_Graph graph,int v){
        for (Edge_Directed e : graph.getAdjBag(v)){
            int w = e.endNode();
            if (distanceTo[w] > distanceTo[v] + e.getWeight()){
                distanceTo[w] = distanceTo[v] + e.getWeight();
                edgeTo[w] = e;
                if (!onQueue[w]){
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
            if (cost++ % graph.getNum_vertex() == 0){

            }
        }
    }

    private void findNegativeCycle(){
        int num_vertex = edgeTo.length;
        Edge_Weighted_Graph spt;
        spt = new Edge_Weighted_Graph(num_vertex);
        for (int v = 0;v < num_vertex;v++){
            if (edgeTo[v] != null){
                spt.addEdge(edgeTo[v]);
            }
        }

    }
}

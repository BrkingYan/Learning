package Graph_Weighted;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.LinkedList;

/*
* 即时Prim算法
* */
public class PrimMST {
    private Edge[] edgeTo;// Edge[i]表示，在当前MST中与i相连的边
    private double[] distanceTo;// distanceTo[i]表示，当前MST中与节点i相连的edge的权重
    private boolean[] marked;//marked[i] 表示节点i是否访问过
    private IndexMinPQ<Double> queue;// (i,key) queue中保存了当前MST中，每个节点的边连接情况，会不断更新

    public PrimMST(Edge_Weighted_Graph graph){
        edgeTo = new Edge[graph.getNum_vertex()];
        distanceTo = new double[graph.getNum_vertex()];
        marked = new boolean[graph.getNum_vertex()];
        queue = new IndexMinPQ<>(graph.getNum_vertex());

        for (int v = 0;v < graph.getNum_vertex();v++){
            distanceTo[v] = Double.POSITIVE_INFINITY;
        }

        distanceTo[0] = 0.0;
        queue.insert(0,0.0);
        while (!queue.isEmpty()){
            visit(graph,queue.delMin());
        }
    }

    private void visit(Edge_Weighted_Graph graph,int cur){
        marked[cur] = true;
        for (Edge e : graph.getAdjBag(cur)){//e是与cur相连的一条边
            int w = e.getAnother(cur);// w 和 cur 通过 e 相连

            //如果这个与cur相连的节点w已经被访问过了，就跳过后续步骤
            if (marked[w]){
                continue;
            }
            // distanceTo[w] 表示当前MST中，与w相连的edge的权重
            // e.getWeight()表示 e的权重
            // 如果发现更小权重，就在distanceTo中更新当前MST中的权重记录
            // 最开始都是和空气连接的，权重为正无穷大
            //这里经过循环之后，能找出与w相连的权重最小的Edge
            if (e.getWeight() < distanceTo[w]){
                edgeTo[w] = e;
                distanceTo[w] = e.getWeight();
                if (queue.contains(w)){
                    queue.changeKey(w,distanceTo[w]);
                }else {
                    queue.insert(w,distanceTo[w]);
                }
            }
        }
    }

    public LinkedList<Edge> edges(){
        LinkedList<Edge> mst = new LinkedList<>();
        for (int v = 1;v < edgeTo.length;v++){
            mst.add(edgeTo[v]);
        }
        return mst;
    }
}

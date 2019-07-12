package Graph_Weighted_Directed;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.LinkedList;

/*
*  SPT 为最短路径树，在SPT 中，任意两点之间的距离都是最短的
* */
public class Dijkstra {
    private Edge_Directed[] edgeTo;//edgeTo[i] 表示当前SPT中，与节点i相连的边
    private double[] distanceTo;// distanceTo[i] 表示当前SPT中，节点i到节点0的距离
    private IndexMinPQ<Double> priorQueue;

    public Dijkstra(Edge_Weighted_Graph graph,int start){
        edgeTo = new Edge_Directed[graph.getNum_vertex()];
        distanceTo = new double[graph.getNum_vertex()];
        priorQueue = new IndexMinPQ<>(graph.getNum_vertex());

        for (int v = 0;v < graph.getNum_vertex();v++){
            distanceTo[v] = Double.POSITIVE_INFINITY;//最开始都和空气相连，因此距离为无穷大
        }
        distanceTo[start] = 0.0;
        priorQueue.insert(0,0.0);

        while (!priorQueue.isEmpty()){
            relax(graph,priorQueue.delMin());
        }
    }

    /*
    * 检查与v相连的所有节点w1、w2、w3 ，看他们当前到节点0的距离是否大于 v 到 0 的距离 + 边v-w 的长度
    *             L
    *  0...---  v---w  如果当前L(0,w) > L(0,v) + L ，说明w在去0的路上走了弯路，因此就需要松弛
    *                  让w不要走弯路，让它直接来v这里
    * */
    private void relax(Edge_Weighted_Graph graph,int v){
        for (Edge_Directed e : graph.getAdjBag(v)){
            int w = e.endNode();

            if (distanceTo[w] > distanceTo[v] + e.getWeight()){
                distanceTo[w] = distanceTo[v] + e.getWeight();//松弛操作
                edgeTo[w] = e;//松弛操作
                if (priorQueue.contains(w)){
                    priorQueue.changeKey(w,distanceTo[w]);
                }else {
                    priorQueue.insert(w,distanceTo[w]);
                }
            }
        }
    }

    public double distanceTo(int v){
        return distanceTo[v];
    }

    public boolean hasPathTo(int v){
        return distanceTo[v] < Double.POSITIVE_INFINITY;
    }

    public LinkedList<Edge_Directed> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        LinkedList<Edge_Directed> path = new LinkedList<>();
        for (Edge_Directed e = edgeTo[v];e != null;e = edgeTo[e.startNode()]){
            path.push(e);
        }
        return path;
    }
}

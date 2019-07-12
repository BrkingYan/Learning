package Graph_Weighted;


import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;

/*
* Kruskal算法是按照边的权重顺序处理，将边加入到MST中
*
*  Kruskal算法能计算任意加权连通图的MST
*
*  是针对边的，不断添加边到MST上
* */
public class Kruskal {
    private LinkedList<Edge> mst;

    public Kruskal(Edge_Weighted_Graph graph){
        mst = new LinkedList<>();
        MinPQ<Edge> priorQueue = new MinPQ<>();

        //将所有边入队，按权重排序
        for (Edge e : graph.edges()){
            priorQueue.insert(e);
        }

        Union_Find uf = new Union_Find(graph.getNum_vertex());

        //最小生成树的顶点数是比边数大1的
        while (!priorQueue.isEmpty() && mst.size() < graph.getNum_vertex()-1){
            //获取权重最小的边
            Edge e = priorQueue.delMin();

            //获取该边连接的两个顶点
            int v = e.getOneNode();
            int w = e.getAnother(v);

            //判断这两个顶点是否连通
            if (uf.isConnectedQuick(v,w)){
                continue;
            }
            //最开始肯定是没连通的，union-find 算法初始化的时候，是N个相互独立的顶点
            //不需要去管UF内的数据结构是怎样的，它虽然没直接操纵图，但是他将这边的顶点映射过去了
            //能判断两个点是否连通

            //如果当前权重最小的两条边不是联通的，就用union方法将其联通
            uf.quickUnion(v,w);
            mst.add(e);
        }
    }

    public LinkedList<Edge> getMst(){
        return mst;
    }
}

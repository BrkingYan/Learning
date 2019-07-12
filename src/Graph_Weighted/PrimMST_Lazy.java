package Graph_Weighted;

import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;

/*
*  Prim算法的每一步都会为一棵生长中的树添加一条边，一开始这棵树只有一个顶点，
*  然后下次将 (连接该顶点点和其他不在树中的顶点) 的边加入优先队列
*
*  该方法为延迟方法， 保存了失效边
* */
public class PrimMST_Lazy {
    private boolean[] marked;
    private LinkedList<Edge> edgesInMST;
    private MinPQ<Edge> priorQueue;

    public PrimMST_Lazy(Edge_Weighted_Graph graph){
        priorQueue = new MinPQ<>();
        marked = new boolean[graph.getNum_vertex()];
        edgesInMST = new LinkedList<>();

        //begin
        visit(graph,0);//从0开始访问
        while (!priorQueue.isEmpty()){
            Edge e = priorQueue.delMin(); //从队列中获取权重最小的边
            int vertex_1 = e.getOneNode();
            int vertex_2 = e.getAnother(vertex_1);

            //如果该边的两个顶点都被标记了，就跳过
            if (marked[vertex_1] && marked[vertex_2]){
                continue;//跳过失效的边
            }

            //如果这两个顶点只有一个被标记，说明这条边是条好边，就收藏起来
            edgesInMST.add(e);

            //去访问另外一个未被标记的顶点
            if (!marked[vertex_1]){
                visit(graph,vertex_1);
            }
            if (!marked[vertex_2]){
                visit(graph,vertex_2);
            }
        }
    }

    private void visit(Edge_Weighted_Graph graph,int v){
        //将当前顶点标记
        marked[v] = true;
        //遍历与该顶点连接的所有边，如果某条边连接的另外一个顶点是未被标记的，就将该边收藏起来
        for (Edge e : graph.getAdjBag(v)){
            if (!marked[e.getAnother(v)]){
                priorQueue.insert(e);
            }
        }
    }

    public Iterable<Edge> edges(){
        return edgesInMST;
    }


}

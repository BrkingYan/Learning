package Graph.DFS_Apps;


import Graph.MyGraph;

/*
*  判断一个图中是否有环
* */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(MyGraph graph){
        marked = new boolean[graph.getNum_Vertex()];
        for (int v = 0;v < graph.getNum_Vertex();v++){
            if (!marked[v]){
                dfs(graph,v,v);
            }
        }
    }
    //cur的子结点v已被访问，且不是结点cur的父结点，则存在环
    private void dfs(MyGraph graph,int cur,int parent ){
        marked[cur] = true;
        for (int v : graph.getAdjBag(cur)){
            if (!marked[v]){
                dfs(graph,v,cur);
            }else if (v != parent){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }
}

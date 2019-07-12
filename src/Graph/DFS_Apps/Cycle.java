package Graph.DFS_Apps;


import Graph.MyGraph;

/*
*  �ж�һ��ͼ���Ƿ��л�
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
    //cur���ӽ��v�ѱ����ʣ��Ҳ��ǽ��cur�ĸ���㣬����ڻ�
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

package Graph_Directed.Algorithms;


import Graph_Directed.MyGraph;
import Graph_Directed.PrePostReverse;

/*
* 该算法用来计算强连通分量，每个强连通分量中的顶点都是相互可达的
*
* 在有向图中，当两个顶点互相可达的时候，称这两个点是强连通的
*
*
* 该算法的原理：
*               对反向图进行dfs来进行拓扑排序(逆后序)
* */
public class Kosaraju {
    private boolean[] marked;
    private int[] groupId;
    private int count;

    public Kosaraju(MyGraph graph){
        marked = new boolean[graph.getNum_vertex()];
        groupId = new int[graph.numOfVertex()];
        PrePostReverse reverse = new PrePostReverse(graph.reverse());
        for (int v : reverse.getReversePost()){
            if (!marked[v]){
                dfs(graph,v);
                count++;
            }
        }
    }

    private void dfs(MyGraph graph,int v){
        marked[v] = true;
        groupId[v] = count;
        for (int w : graph.getNeighbors(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }

    public boolean stronglyConnected(int a,int b){
        return groupId[a] == groupId[b];
    }

    public int id(int v){
        return groupId[v];
    }

    public int getCount(){
        return count;
    }
}

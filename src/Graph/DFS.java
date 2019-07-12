package Graph;

import java.util.LinkedList;


/*
* 深度优先搜索 Depth First Search，它隐式地使用了栈(递归)
*
*  DFS能解决的问题：
*                   1、两个给定的顶点是否连通  || 图中有多少个连通子图(连通分量)如果一个图中任意两点间都能到达，那么就是连通图
*                        联通分量就是计算每个元素和其他那几个元素能直接相连
*                   2、从起点start到给定目标节点dest是否存在一条路径，如果有，找出这条路径
* */
public class DFS {
    private boolean[] markedForTotal;
    private boolean[] markedForSearch;
    private int[] vertexToBack;//这个数组很重要，用来记录当前结点是从哪个节点过来的，方便原路返回

    private int startVertex;

    private static int total;

    public DFS(MyGraph graph,int start){
        markedForTotal = new boolean[graph.getNum_Vertex()];
        markedForSearch = new boolean[graph.getNum_Vertex()];
        vertexToBack = new int[graph.getNum_Vertex()];
        dfs(graph,start);//创建DFS的时候就把它遍历一遍
        startVertex = start;
    }

    private void dfs(MyGraph graph,int start){
        markedForTotal[start] = true;
        total++;
        for (int nei : graph.getAdjBag(start)){
            if (!markedForTotal[nei]){
                vertexToBack[nei] = start;//记录nei是从start过来的
                dfs(graph,nei);
            }
        }
    }


    // 原路返回
    public LinkedList<Integer> pathTo(int vertex){
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = vertex;i != startVertex;i = vertexToBack[i]){
            stack.push(i);
        }
        stack.push(startVertex);
        return stack;
    }

    public boolean hasPathTo(int vertex){
        return markedForTotal[vertex];
    }

    public int getTotal(){
        return total;
    }
}

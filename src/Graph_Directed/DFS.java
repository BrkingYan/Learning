package Graph_Directed;

import java.util.LinkedList;

public class DFS {

    private boolean[] marked;
    private int[] vertexToBack;
    private int start;
    private int totalCount;
    private MyGraph graph;

    public DFS(MyGraph graph,int start){
        marked = new boolean[graph.numOfVertex()];
        vertexToBack = new int[graph.numOfVertex()];
        this.start = start;
        this.graph = graph;
    }


    public void dfs(int vertex){
        marked[vertex] = true;
        for (int nei : graph.getNeighbors(vertex)){
            if (!marked[nei]){
                totalCount++;
                vertexToBack[nei] = vertex;
                dfs(nei);
            }
        }
    }



    public LinkedList<Integer> pathTo(int dest){
        if (!marked[dest]){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int cur = dest;cur != start;cur = vertexToBack[cur]){
            stack.push(cur);
        }
        stack.push(start);
        return stack;
    }


    public boolean hasPathTo(int dest){
        return marked[dest];
    }

    public void reset(int start){
        this.start = start;
        marked = new boolean[graph.numOfVertex()];
        vertexToBack = new int[graph.numOfVertex()];
    }
}

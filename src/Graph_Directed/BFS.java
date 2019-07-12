package Graph_Directed;

import java.util.LinkedList;

public class BFS {

    private boolean[] marked;
    private int[] vertexToBack;
    private int start;
    private int totalCount;
    private MyGraph graph;

    public BFS(MyGraph graph,int start){
        marked = new boolean[graph.numOfVertex()];
        vertexToBack = new int[graph.numOfVertex()];
        this.start = start;
        this.graph = graph;
    }


    public void bfs(){

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        marked[start] = true;
        totalCount++;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            //将cur的背包里的未被标记的邻居全部装进去
            for (int v : graph.getNeighbors(cur)){
                if (!marked[v]){
                    marked[v] = true;
                    queue.add(v);
                    vertexToBack[v] = cur;
                    totalCount++;
                }
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

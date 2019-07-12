package Graph;


import java.util.LinkedList;

/*
* 广度优先搜索 BFS  ，它是为了去寻找最短路劲而存在的，它显式地使用了一个队列
*
* */
public class BFS {
    private boolean[] marked;
    private int[] vertexToBack;
    private int start;
    private static int total;

    public BFS(MyGraph graph,int start){
        this.start = start;
        marked = new boolean[graph.getNum_Vertex()];
        vertexToBack = new int[graph.getNum_Vertex()];
        bfs(graph,start);
    }

    private void bfs(MyGraph graph,int start){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        marked[start] = true;
        total++;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int vertex : graph.getAdjBag(current)){
                if (!marked[vertex]){
                    queue.add(vertex);
                    vertexToBack[vertex] = current;
                    marked[vertex] = true;
                    total++;
                }
            }
        }
    }

    //该方法用于判断从起点是否有路径到dest
    public boolean hasPathTo(int dest){
        return marked[dest];
    }

    //仍然是原路返回
    public LinkedList<Integer> pathTo(int dest){
        LinkedList<Integer> stack = new LinkedList<>();
        for (int cur = dest;cur != start;cur = vertexToBack[cur]){
            stack.push(cur);
        }
        stack.push(start);
        return stack;
    }


    public int getTotal(){
        return total;
    }
}

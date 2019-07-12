package Graph;


import java.util.LinkedList;

/*
* ����������� BFS  ������Ϊ��ȥѰ�����·�������ڵģ�����ʽ��ʹ����һ������
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

    //�÷��������жϴ�����Ƿ���·����dest
    public boolean hasPathTo(int dest){
        return marked[dest];
    }

    //��Ȼ��ԭ·����
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

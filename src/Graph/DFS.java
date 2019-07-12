package Graph;

import java.util.LinkedList;


/*
* ����������� Depth First Search������ʽ��ʹ����ջ(�ݹ�)
*
*  DFS�ܽ�������⣺
*                   1�����������Ķ����Ƿ���ͨ  || ͼ���ж��ٸ���ͨ��ͼ(��ͨ����)���һ��ͼ����������䶼�ܵ����ô������ͨͼ
*                        ��ͨ�������Ǽ���ÿ��Ԫ�غ������Ǽ���Ԫ����ֱ������
*                   2�������start������Ŀ��ڵ�dest�Ƿ����һ��·��������У��ҳ�����·��
* */
public class DFS {
    private boolean[] markedForTotal;
    private boolean[] markedForSearch;
    private int[] vertexToBack;//����������Ҫ��������¼��ǰ����Ǵ��ĸ��ڵ�����ģ�����ԭ·����

    private int startVertex;

    private static int total;

    public DFS(MyGraph graph,int start){
        markedForTotal = new boolean[graph.getNum_Vertex()];
        markedForSearch = new boolean[graph.getNum_Vertex()];
        vertexToBack = new int[graph.getNum_Vertex()];
        dfs(graph,start);//����DFS��ʱ��Ͱ�������һ��
        startVertex = start;
    }

    private void dfs(MyGraph graph,int start){
        markedForTotal[start] = true;
        total++;
        for (int nei : graph.getAdjBag(start)){
            if (!markedForTotal[nei]){
                vertexToBack[nei] = start;//��¼nei�Ǵ�start������
                dfs(graph,nei);
            }
        }
    }


    // ԭ·����
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

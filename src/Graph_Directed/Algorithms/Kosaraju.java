package Graph_Directed.Algorithms;


import Graph_Directed.MyGraph;
import Graph_Directed.PrePostReverse;

/*
* ���㷨��������ǿ��ͨ������ÿ��ǿ��ͨ�����еĶ��㶼���໥�ɴ��
*
* ������ͼ�У����������㻥��ɴ��ʱ�򣬳�����������ǿ��ͨ��
*
*
* ���㷨��ԭ��
*               �Է���ͼ����dfs��������������(�����)
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

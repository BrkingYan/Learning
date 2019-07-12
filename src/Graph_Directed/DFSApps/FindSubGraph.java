package Graph_Directed.DFSApps;


import Graph_Directed.MyGraph;

import java.util.LinkedList;

/*
*
* */
public class FindSubGraph {
    private boolean[] marked;
    private int[] groupId;//�����齫����ͼ���飬��һ��ͼ�ڵ����нڵ������ͬid��id��ͬ��ζ������֮��û��·���ܹ�����
    private int[] vertexToBack;
    private int count;
    private int start;


    public FindSubGraph(MyGraph graph){
        marked = new boolean[graph.getNum_vertex()];
        groupId = new int[graph.getNum_vertex()];
        vertexToBack = new int[graph.getNum_vertex()];

        for (int cur = 0;cur < graph.getNum_vertex();cur++){
            if (!marked[cur]){
                dfs(graph,cur);//ִ����������ʱ�򣬻Ὣcur��������ߵ�����δ��ǵ�·�����߱�
                //��һ��curΪ0����˻Ὣ0�ܵ���ĵط�ȫ���߱飬�ܱ�0�ߵ���δ����ǵĽڵ㣬id��Ϊ0
                //�ڶ���curΪ1���ܱ�1�ߵ���δ����ǵĽڵ㣬id��Ϊ1������1���ߵĵط�������ǹ���
                //�������ڵ�Ϊ2��2��������ھӶ�������ˣ����2������������
                count++;
            }
        }
    }

    public FindSubGraph(MyGraph graph,int start){
        marked = new boolean[graph.getNum_vertex()];
        groupId = new int[graph.getNum_vertex()];
        vertexToBack = new int[graph.getNum_vertex()];

        for (int cur = start;cur < graph.getNum_vertex();cur++){
            if (!marked[cur]){
                dfs(graph,cur);
                count++;
            }
        }
    }

    /*
    *  dfs �����ܽ�start���ڵ�ͼ��������һ�飬��ͼ�����нڵ��ǣ�����¼��·
    * */
    private void dfs(MyGraph graph,int start){
        marked[start] = true;
        groupId[start] = count;
        this.start = start;
        for (int v : graph.getNeighbors(start)){
            if(!marked[v]){
                vertexToBack[v] = start;
                dfs(graph,v);
            }
        }
    }

    // from start to dest
    public LinkedList<Integer> pathTo(int dest){
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = dest;i != start;i=vertexToBack[i]){
            stack.push(i);
        }
        stack.push(start);
        return stack;
    }

    public LinkedList<Integer> pathToRange(int src,int dest){
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = dest;i != src;i=vertexToBack[i]){
            stack.push(i);
        }
        stack.push(src);
        return stack;
    }

    public int getCount(){
        return count;
    }

    public int id(int v){
        return groupId[v];
    }

    public boolean isConnected(int a,int b){
        return groupId[a] == groupId[b];
    }
}

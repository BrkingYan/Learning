package Graph_Directed.DFSApps;


import Graph_Directed.MyGraph;

import java.util.ArrayList;
import java.util.LinkedList;

/*
*  �ж�һ��ͼ���Ƿ��л�����û���Ի���ƽ�л��������
* */
public class Cycle {
    private boolean[] marked;
    private int[] vertexToBack;
    private boolean[] onStack;//�ݹ����ջ�ϵ����ж��㣬��ǰ�켣���ϵ����нڵ�
    private boolean hasCycle;
    private int circleNum;
    private ArrayList<LinkedList<Integer>> cycles;
    private LinkedList<Integer> cycle;

    public Cycle(MyGraph graph){
        cycles = new ArrayList<>();
        marked = new boolean[graph.getNum_vertex()];
        onStack = new boolean[graph.getNum_vertex()];
        vertexToBack = new int[graph.getNum_vertex()];
        for (int v = 0;v < graph.getNum_vertex();v++){
            if (!marked[v]){
                dfs(graph,v);
            }
        }
    }
    //cur���ӽ��v�ѱ����ʣ��Ҳ��ǽ��cur�ĸ���㣬����ڻ�
    private void dfs(MyGraph graph,int cur){
        onStack[cur] = true;
        marked[cur] = true;
        for (int v : graph.getNeighbors(cur)){
            if (!marked[v]){
                vertexToBack[v] = cur;
                dfs(graph,v);
            }else if (onStack[v]){
                cycle = new LinkedList<>();
                for (int x = cur;x != v;x = vertexToBack[x]){
                    cycle.push(x);
                }
                cycle.push(v);
                cycle.push(cur);
                cycles.add(cycle);
            }
        }
        onStack[cur] = false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public int getCircleNum(){
        return circleNum;
    }

    public ArrayList<LinkedList<Integer>> getCycles(){
        return cycles;
    }

}

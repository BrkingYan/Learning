package Graph_Directed.DFSApps;


import Graph_Directed.MyGraph;

import java.util.ArrayList;
import java.util.LinkedList;

/*
*  判断一个图中是否有环，在没有自环和平行环的情况下
* */
public class Cycle {
    private boolean[] marked;
    private int[] vertexToBack;
    private boolean[] onStack;//递归调用栈上的所有顶点，当前轨迹线上的所有节点
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
    //cur的子结点v已被访问，且不是结点cur的父结点，则存在环
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

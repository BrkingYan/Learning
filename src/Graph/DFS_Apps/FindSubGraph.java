package Graph.DFS_Apps;


import Graph.MyGraph;

import java.util.LinkedList;

/*
*
* */
public class FindSubGraph {
    private boolean[] marked;
    private int[] groupId;//该数组将整个图分组，在一个图内的所有节点具有相同id，id不同意味着它们之间没有路径能够到达
    private int[] vertexToBack;
    private int count;
    private int start;
    //                 2
    //                |
    /*          1 --- 0 ------------- 6              7-- 8
    *                 |            3  |
    *                 |             \ |               9-- 10
    *                 5 ------------- 4               | ＼
    *                                                 11--12
    * */

    public FindSubGraph(MyGraph graph){
        marked = new boolean[graph.getNum_Vertex()];
        groupId = new int[graph.getNum_Vertex()];
        vertexToBack = new int[graph.getNum_Vertex()];

        for (int cur = 0;cur < graph.getNum_Vertex();cur++){
            if (!marked[cur]){
                dfs(graph,cur);//执行这条语句的时候，会将cur这个点能走的所有未标记的路径都走遍
                //第一个cur为0，因此会将0能到达的地方全部走遍，能被0走到的未被标记的节点，id都为0
                //第二个cur为1，能被1走到的未被标记的节点，id都为1，但是1能走的地方都被标记过了
                //第三个节点为2，2背包里的邻居都被标记了，因此2处不能往哪走
                count++;
            }
        }
    }

    public FindSubGraph(MyGraph graph,int start){
        marked = new boolean[graph.getNum_Vertex()];
        groupId = new int[graph.getNum_Vertex()];
        vertexToBack = new int[graph.getNum_Vertex()];

        for (int cur = start;cur < graph.getNum_Vertex();cur++){
            if (!marked[cur]){
                dfs(graph,cur);
                count++;
            }
        }
    }

    /*
    *  dfs 方法能将start所在的图整个遍历一遍，将图中所有节点标记，并记录退路
    * */
    private void dfs(MyGraph graph,int start){
        marked[start] = true;
        groupId[start] = count;
        this.start = start;
        for (int v : graph.getAdjBag(start)){
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

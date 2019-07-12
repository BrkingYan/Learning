package Graph_Directed;

import java.util.LinkedList;

/*
*   前序：就是按照dfs，先后走过的未被标记过的顶点的序列，dfs的调用顺序
*   后序：顶点遍历完成的顺序，就是无路可走的所有顶点的序列
*           (第一个无路可走的顶点，第二个无路可走的顶点，......，最后一个无路可走的顶点)
*   逆序：若存在一条从顶点 A 到顶点 B 的路径，那么在序列中顶点 A 出现在顶点 B 的前面，即A,B
* */

public class PrePostReverse {
    private boolean[] marked;
    private LinkedList<Integer> pre;//queue  所有节点的前序排列
    private LinkedList<Integer> post;//queue 所有节点的后序排列
    private LinkedList<Integer> reversePost;//逆后序 stack  所有节点的逆后序排列
    public PrePostReverse(MyGraph graph){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new LinkedList<>();
        marked = new boolean[graph.getNum_vertex()];

        for (int v = 0;v < graph.getNum_vertex();v++){
            if (!marked[v]){
                dfs(graph,v);
            }
        }
    }

    private void dfs(MyGraph graph,int v){
        pre.add(v);//在递归调用之前将顶点加入队列
        marked[v] = true;
        for (int w : graph.getNeighbors(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
        post.add(v);//在递归调用之后将顶点加入队列
        reversePost.push(v);//在递归调用之后将顶点压入栈
    }

    public LinkedList<Integer> getPre(){
        return pre;
    }

    public LinkedList<Integer> getPost(){
        return post;
    }

    public Iterable<Integer> getReversePost() {
        return reversePost;
    }
}

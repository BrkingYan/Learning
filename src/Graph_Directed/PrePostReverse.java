package Graph_Directed;

import java.util.LinkedList;

/*
*   ǰ�򣺾��ǰ���dfs���Ⱥ��߹���δ����ǹ��Ķ�������У�dfs�ĵ���˳��
*   ���򣺶��������ɵ�˳�򣬾�����·���ߵ����ж��������
*           (��һ����·���ߵĶ��㣬�ڶ�����·���ߵĶ��㣬......�����һ����·���ߵĶ���)
*   ����������һ���Ӷ��� A ������ B ��·������ô�������ж��� A �����ڶ��� B ��ǰ�棬��A,B
* */

public class PrePostReverse {
    private boolean[] marked;
    private LinkedList<Integer> pre;//queue  ���нڵ��ǰ������
    private LinkedList<Integer> post;//queue ���нڵ�ĺ�������
    private LinkedList<Integer> reversePost;//����� stack  ���нڵ�����������
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
        pre.add(v);//�ڵݹ����֮ǰ������������
        marked[v] = true;
        for (int w : graph.getNeighbors(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
        post.add(v);//�ڵݹ����֮�󽫶���������
        reversePost.push(v);//�ڵݹ����֮�󽫶���ѹ��ջ
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

package Graph_Weighted;

import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;

/*
*  Prim�㷨��ÿһ������Ϊһ�������е������һ���ߣ�һ��ʼ�����ֻ��һ�����㣬
*  Ȼ���´ν� (���Ӹö����������������еĶ���) �ı߼������ȶ���
*
*  �÷���Ϊ�ӳٷ����� ������ʧЧ��
* */
public class PrimMST_Lazy {
    private boolean[] marked;
    private LinkedList<Edge> edgesInMST;
    private MinPQ<Edge> priorQueue;

    public PrimMST_Lazy(Edge_Weighted_Graph graph){
        priorQueue = new MinPQ<>();
        marked = new boolean[graph.getNum_vertex()];
        edgesInMST = new LinkedList<>();

        //begin
        visit(graph,0);//��0��ʼ����
        while (!priorQueue.isEmpty()){
            Edge e = priorQueue.delMin(); //�Ӷ����л�ȡȨ����С�ı�
            int vertex_1 = e.getOneNode();
            int vertex_2 = e.getAnother(vertex_1);

            //����ñߵ��������㶼������ˣ�������
            if (marked[vertex_1] && marked[vertex_2]){
                continue;//����ʧЧ�ı�
            }

            //�������������ֻ��һ������ǣ�˵�������������ñߣ����ղ�����
            edgesInMST.add(e);

            //ȥ��������һ��δ����ǵĶ���
            if (!marked[vertex_1]){
                visit(graph,vertex_1);
            }
            if (!marked[vertex_2]){
                visit(graph,vertex_2);
            }
        }
    }

    private void visit(Edge_Weighted_Graph graph,int v){
        //����ǰ������
        marked[v] = true;
        //������ö������ӵ����бߣ����ĳ�������ӵ�����һ��������δ����ǵģ��ͽ��ñ��ղ�����
        for (Edge e : graph.getAdjBag(v)){
            if (!marked[e.getAnother(v)]){
                priorQueue.insert(e);
            }
        }
    }

    public Iterable<Edge> edges(){
        return edgesInMST;
    }


}

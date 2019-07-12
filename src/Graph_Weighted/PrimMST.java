package Graph_Weighted;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.LinkedList;

/*
* ��ʱPrim�㷨
* */
public class PrimMST {
    private Edge[] edgeTo;// Edge[i]��ʾ���ڵ�ǰMST����i�����ı�
    private double[] distanceTo;// distanceTo[i]��ʾ����ǰMST����ڵ�i������edge��Ȩ��
    private boolean[] marked;//marked[i] ��ʾ�ڵ�i�Ƿ���ʹ�
    private IndexMinPQ<Double> queue;// (i,key) queue�б����˵�ǰMST�У�ÿ���ڵ�ı�����������᲻�ϸ���

    public PrimMST(Edge_Weighted_Graph graph){
        edgeTo = new Edge[graph.getNum_vertex()];
        distanceTo = new double[graph.getNum_vertex()];
        marked = new boolean[graph.getNum_vertex()];
        queue = new IndexMinPQ<>(graph.getNum_vertex());

        for (int v = 0;v < graph.getNum_vertex();v++){
            distanceTo[v] = Double.POSITIVE_INFINITY;
        }

        distanceTo[0] = 0.0;
        queue.insert(0,0.0);
        while (!queue.isEmpty()){
            visit(graph,queue.delMin());
        }
    }

    private void visit(Edge_Weighted_Graph graph,int cur){
        marked[cur] = true;
        for (Edge e : graph.getAdjBag(cur)){//e����cur������һ����
            int w = e.getAnother(cur);// w �� cur ͨ�� e ����

            //��������cur�����Ľڵ�w�Ѿ������ʹ��ˣ���������������
            if (marked[w]){
                continue;
            }
            // distanceTo[w] ��ʾ��ǰMST�У���w������edge��Ȩ��
            // e.getWeight()��ʾ e��Ȩ��
            // ������ָ�СȨ�أ�����distanceTo�и��µ�ǰMST�е�Ȩ�ؼ�¼
            // �ʼ���ǺͿ������ӵģ�Ȩ��Ϊ�������
            //���ﾭ��ѭ��֮�����ҳ���w������Ȩ����С��Edge
            if (e.getWeight() < distanceTo[w]){
                edgeTo[w] = e;
                distanceTo[w] = e.getWeight();
                if (queue.contains(w)){
                    queue.changeKey(w,distanceTo[w]);
                }else {
                    queue.insert(w,distanceTo[w]);
                }
            }
        }
    }

    public LinkedList<Edge> edges(){
        LinkedList<Edge> mst = new LinkedList<>();
        for (int v = 1;v < edgeTo.length;v++){
            mst.add(edgeTo[v]);
        }
        return mst;
    }
}

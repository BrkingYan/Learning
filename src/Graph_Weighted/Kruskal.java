package Graph_Weighted;


import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;

/*
* Kruskal�㷨�ǰ��ձߵ�Ȩ��˳�������߼��뵽MST��
*
*  Kruskal�㷨�ܼ��������Ȩ��ͨͼ��MST
*
*  ����Աߵģ�������ӱߵ�MST��
* */
public class Kruskal {
    private LinkedList<Edge> mst;

    public Kruskal(Edge_Weighted_Graph graph){
        mst = new LinkedList<>();
        MinPQ<Edge> priorQueue = new MinPQ<>();

        //�����б���ӣ���Ȩ������
        for (Edge e : graph.edges()){
            priorQueue.insert(e);
        }

        Union_Find uf = new Union_Find(graph.getNum_vertex());

        //��С�������Ķ������Ǳȱ�����1��
        while (!priorQueue.isEmpty() && mst.size() < graph.getNum_vertex()-1){
            //��ȡȨ����С�ı�
            Edge e = priorQueue.delMin();

            //��ȡ�ñ����ӵ���������
            int v = e.getOneNode();
            int w = e.getAnother(v);

            //�ж������������Ƿ���ͨ
            if (uf.isConnectedQuick(v,w)){
                continue;
            }
            //�ʼ�϶���û��ͨ�ģ�union-find �㷨��ʼ����ʱ����N���໥�����Ķ���
            //����Ҫȥ��UF�ڵ����ݽṹ�������ģ�����Ȼûֱ�Ӳ���ͼ������������ߵĶ���ӳ���ȥ��
            //���ж��������Ƿ���ͨ

            //�����ǰȨ����С�������߲�����ͨ�ģ�����union����������ͨ
            uf.quickUnion(v,w);
            mst.add(e);
        }
    }

    public LinkedList<Edge> getMst(){
        return mst;
    }
}

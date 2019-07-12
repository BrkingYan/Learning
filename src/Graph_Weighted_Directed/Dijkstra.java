package Graph_Weighted_Directed;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.LinkedList;

/*
*  SPT Ϊ���·��������SPT �У���������֮��ľ��붼����̵�
* */
public class Dijkstra {
    private Edge_Directed[] edgeTo;//edgeTo[i] ��ʾ��ǰSPT�У���ڵ�i�����ı�
    private double[] distanceTo;// distanceTo[i] ��ʾ��ǰSPT�У��ڵ�i���ڵ�0�ľ���
    private IndexMinPQ<Double> priorQueue;

    public Dijkstra(Edge_Weighted_Graph graph,int start){
        edgeTo = new Edge_Directed[graph.getNum_vertex()];
        distanceTo = new double[graph.getNum_vertex()];
        priorQueue = new IndexMinPQ<>(graph.getNum_vertex());

        for (int v = 0;v < graph.getNum_vertex();v++){
            distanceTo[v] = Double.POSITIVE_INFINITY;//�ʼ���Ϳ�����������˾���Ϊ�����
        }
        distanceTo[start] = 0.0;
        priorQueue.insert(0,0.0);

        while (!priorQueue.isEmpty()){
            relax(graph,priorQueue.delMin());
        }
    }

    /*
    * �����v���������нڵ�w1��w2��w3 �������ǵ�ǰ���ڵ�0�ľ����Ƿ���� v �� 0 �ľ��� + ��v-w �ĳ���
    *             L
    *  0...---  v---w  �����ǰL(0,w) > L(0,v) + L ��˵��w��ȥ0��·��������·����˾���Ҫ�ɳ�
    *                  ��w��Ҫ����·������ֱ����v����
    * */
    private void relax(Edge_Weighted_Graph graph,int v){
        for (Edge_Directed e : graph.getAdjBag(v)){
            int w = e.endNode();

            if (distanceTo[w] > distanceTo[v] + e.getWeight()){
                distanceTo[w] = distanceTo[v] + e.getWeight();//�ɳڲ���
                edgeTo[w] = e;//�ɳڲ���
                if (priorQueue.contains(w)){
                    priorQueue.changeKey(w,distanceTo[w]);
                }else {
                    priorQueue.insert(w,distanceTo[w]);
                }
            }
        }
    }

    public double distanceTo(int v){
        return distanceTo[v];
    }

    public boolean hasPathTo(int v){
        return distanceTo[v] < Double.POSITIVE_INFINITY;
    }

    public LinkedList<Edge_Directed> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        LinkedList<Edge_Directed> path = new LinkedList<>();
        for (Edge_Directed e = edgeTo[v];e != null;e = edgeTo[e.startNode()]){
            path.push(e);
        }
        return path;
    }
}

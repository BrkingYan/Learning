package Graph;

import edu.princeton.cs.algs4.Bag;

public class MyGraph {
    private int num_Vertex;//������
    private int num_Edge;//����
    private Bag<Integer>[] neighborsArray; //�ڽӱ����飬�����ÿ��Ԫ�ض���һ���ڽӱ�

    public MyGraph(int num_Vertex){
        this.num_Vertex = num_Vertex;
        neighborsArray = (Bag<Integer>[]) new Bag[num_Vertex];
        this.num_Edge = 0;
        for (int i = 0;i<num_Vertex;i++){
            neighborsArray[i] = new Bag<>();
        }
    }

    //������Ԫ������
    //��neighbor��ӵ�vertex�������У���vertex��ӵ�nerghbor��������
    public void addEdge(int vertex,int neighbor){
        neighborsArray[vertex].add(neighbor);
        neighborsArray[neighbor].add(vertex);
        num_Edge++;
    }

    public Bag<Integer> getAdjBag(int vertex){
        return neighborsArray[vertex];
    }

    public int getNum_Vertex(){
        return num_Vertex;
    }

    public int getNum_Edge(){
        return num_Edge;
    }

    @Override
    public String toString() {
        String s = num_Vertex + " vertices, " + num_Edge + " edges\n";
        for (int i = 0;i<num_Vertex;i++){
            s += i + ": ";
            for (int nei : this.getAdjBag(i)){
                s += nei + " ";
            }
            s += "\n";
        }
        return s;
    }

}

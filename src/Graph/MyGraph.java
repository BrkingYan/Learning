package Graph;

import edu.princeton.cs.algs4.Bag;

public class MyGraph {
    private int num_Vertex;//顶点数
    private int num_Edge;//边数
    private Bag<Integer>[] neighborsArray; //邻接表数组，数组的每个元素都是一个邻接表

    public MyGraph(int num_Vertex){
        this.num_Vertex = num_Vertex;
        neighborsArray = (Bag<Integer>[]) new Bag[num_Vertex];
        this.num_Edge = 0;
        for (int i = 0;i<num_Vertex;i++){
            neighborsArray[i] = new Bag<>();
        }
    }

    //将两个元素连接
    //将neighbor添加到vertex的链表中，将vertex添加到nerghbor的链表中
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

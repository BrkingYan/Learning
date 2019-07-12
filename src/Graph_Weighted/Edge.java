package Graph_Weighted;

public class Edge implements Comparable<Edge> {
    private final int node1;
    private final int node2;
    private final double weight;

    public Edge(int node1,int node2,double weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int getOneNode(){
        return node1;
    }

    public int getAnother(int v){
        if (v == node1){
            return node2;
        }else if (v == node2){
            return node1;
        }else {
            throw new RuntimeException("Inconsistent edge");
        }
    }



    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight){
            return -1;
        }else if (this.weight > that.weight){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return String.format("%d-%d %.2f",node1,node2,weight);
    }
}

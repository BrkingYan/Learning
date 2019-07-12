package Graph_Weighted_Directed;


/*
* ÓĞÏò±ß
* */
public class Edge_Directed {
    private final int start;
    private final int end;
    private final double weight;

    public Edge_Directed(int start,int end,double weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int startNode(){
        return start;
    }

    public int endNode(){
        return end;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f",start,end,weight);
    }
}

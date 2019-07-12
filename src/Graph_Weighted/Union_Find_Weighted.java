package Graph_Weighted;


/*
* 加权的Union_Find算法
*
*       该算法是对 Quick Union的改进，加权的union find 规定小树的父亲必须是大树，小树的父亲不能比小树还小
*
*       这样做会提高算法的效率，使其能处理规模较大的问题
*       普通的 quick-union 算法，随着链接的增多，find方法的成本会越来越高，
*       加权的 quick-union 算法，随着链接的增多，find方法的成本不会增加太多
* */
public class Union_Find_Weighted {
    private int[] parent;
    private int[] sizeOf;
    private int count;

    public Union_Find_Weighted(int N){
        count = N;
        parent = new int[N];
        for (int i = 0;i<N;i++){
            parent[i] = i;//最开始时，每个节点都是独立的
        }
        sizeOf = new int[N];

        for (int i = 0;i<N;i++){
            sizeOf[i] = 1;//最开始每棵树大小都为1
        }
    }

    public boolean isConnected(int a,int b){
        return find(a) == find(b);
    }

    public int find(int v){
        while (v != parent[v]){
            v = parent[v];
        }
        return v;
    }

    public void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot){
            return;
        }
        //只能将小树连接到大树，不能反过来
        if (sizeOf[aRoot] < sizeOf[bRoot]){
            parent[aRoot] = bRoot;
            sizeOf[bRoot] += sizeOf[aRoot];
        }else {
            parent[bRoot] = aRoot;
            sizeOf[aRoot] += sizeOf[bRoot];
        }
        count--;
    }

    // 返回连通分量的个数
    public int getCount(){
        return count;
    }
}

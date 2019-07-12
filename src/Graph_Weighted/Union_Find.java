package Graph_Weighted;


/*
*  Union-Find 算法，用于解决动态连通性问题
*
*   union 方法是用于将两个点连通起来
*   一、普通的find-union 是用groupId[]给每个节点编队，在同一队里的节点是互相可达的。
*   二、quick-union 是通过连接的方式，parent[]存放的是每个节点的父节点，因此find方法会通过引用去寻找，看 能否
*
*    find 方法用于查询某个节点的id     union 方法用于连接两个节点，并将两个节点所在的图整个连通起来
*    isConnected()方法通过find方法来判断两个节点是否连通
*
*                                   8
*               1                 /  \
*             / | \              3    9
*            0  2  7             |
*            |                   4
*            5
*           |
*           6
*
*          在quick union 中对应的就是   i             0 1 2 3 4 5 6 7 8 9
*                                       parent[i]     1 1 1 8 3 0 5 1 8 8
*
*                        quick union 只用将 parent[1] 改为8，就能将两个森林连接起来
*
* */
public class Union_Find {
    private int[] groupId;// for plain union

    private int[] parent;// for quick union
    private int count;

    public Union_Find(int N){
        count = N;
        groupId = new int[N];
        parent = new int[N];
        for (int i = 0;i<N;i++){
            groupId[i] = i;
            parent[i] = i;//最开始的时候，每个人都是自己的父亲
        }
    }

    public boolean isConnected(int a,int b){
        return find(a) == find(b);
    }

    public boolean isConnectedQuick(int a,int b){
        return quickFind(a) == quickFind(b);
    }

    public int find(int a){
        return groupId[a];
    }

    public void union(int a,int b){
        int aId = find(a);
        int bId = find(b);

        if (aId == bId){
            return;
        }

        for (int i = 0;i < groupId.length;i++){
            if (groupId[i] == aId){
                groupId[i] = bId;//把所有和aId等的都变为bId，就是把原来和a在一个group里的元素的ID，变成和b的一样
            }
        }
        count--;
    }



    public int quickFind(int a){
        while (a != parent[a]){
            a = parent[a];
        }
        return a;
    }

    // quickUnion 比 union快些，因为只用修改链接就能完成连通性的归并
    public void quickUnion(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot){
            return;
        }
        groupId[aRoot] = bRoot;
        count--;
    }
}

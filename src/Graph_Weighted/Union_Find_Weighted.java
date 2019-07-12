package Graph_Weighted;


/*
* ��Ȩ��Union_Find�㷨
*
*       ���㷨�Ƕ� Quick Union�ĸĽ�����Ȩ��union find �涨С���ĸ��ױ����Ǵ�����С���ĸ��ײ��ܱ�С����С
*
*       ������������㷨��Ч�ʣ�ʹ���ܴ����ģ�ϴ������
*       ��ͨ�� quick-union �㷨���������ӵ����࣬find�����ĳɱ���Խ��Խ�ߣ�
*       ��Ȩ�� quick-union �㷨���������ӵ����࣬find�����ĳɱ���������̫��
* */
public class Union_Find_Weighted {
    private int[] parent;
    private int[] sizeOf;
    private int count;

    public Union_Find_Weighted(int N){
        count = N;
        parent = new int[N];
        for (int i = 0;i<N;i++){
            parent[i] = i;//�ʼʱ��ÿ���ڵ㶼�Ƕ�����
        }
        sizeOf = new int[N];

        for (int i = 0;i<N;i++){
            sizeOf[i] = 1;//�ʼÿ������С��Ϊ1
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
        //ֻ�ܽ�С�����ӵ����������ܷ�����
        if (sizeOf[aRoot] < sizeOf[bRoot]){
            parent[aRoot] = bRoot;
            sizeOf[bRoot] += sizeOf[aRoot];
        }else {
            parent[bRoot] = aRoot;
            sizeOf[aRoot] += sizeOf[bRoot];
        }
        count--;
    }

    // ������ͨ�����ĸ���
    public int getCount(){
        return count;
    }
}

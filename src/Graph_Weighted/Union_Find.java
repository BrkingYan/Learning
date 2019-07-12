package Graph_Weighted;


/*
*  Union-Find �㷨�����ڽ����̬��ͨ������
*
*   union ���������ڽ���������ͨ����
*   һ����ͨ��find-union ����groupId[]��ÿ���ڵ��ӣ���ͬһ����Ľڵ��ǻ���ɴ�ġ�
*   ����quick-union ��ͨ�����ӵķ�ʽ��parent[]��ŵ���ÿ���ڵ�ĸ��ڵ㣬���find������ͨ������ȥѰ�ң��� �ܷ�
*
*    find �������ڲ�ѯĳ���ڵ��id     union �����������������ڵ㣬���������ڵ����ڵ�ͼ������ͨ����
*    isConnected()����ͨ��find�������ж������ڵ��Ƿ���ͨ
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
*          ��quick union �ж�Ӧ�ľ���   i             0 1 2 3 4 5 6 7 8 9
*                                       parent[i]     1 1 1 8 3 0 5 1 8 8
*
*                        quick union ֻ�ý� parent[1] ��Ϊ8�����ܽ�����ɭ����������
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
            parent[i] = i;//�ʼ��ʱ��ÿ���˶����Լ��ĸ���
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
                groupId[i] = bId;//�����к�aId�ȵĶ���ΪbId�����ǰ�ԭ����a��һ��group���Ԫ�ص�ID����ɺ�b��һ��
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

    // quickUnion �� union��Щ����Ϊֻ���޸����Ӿ��������ͨ�ԵĹ鲢
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

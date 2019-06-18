package SwordToOffer.NK46.LastRemaining_Solution;


import java.util.LinkedList;

/*
*  ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
*  HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
*  ����,�и���Ϸ��������:
*  ����,��С������Χ��һ����Ȧ��
*  Ȼ��,�����ָ��һ����m,�ñ��Ϊ0 ��С���ѿ�ʼ������
*  ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,
*  ���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,
*  ���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
*  ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0 ��n-1)
*
*  nΪС���Ѹ�����mΪ�����
* */
class Solution {

    public int LastRemaining_Solution(int n, int m) {
        if (n==0){
            return -1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0;i<n;i++){
            queue.add(i);
        }
        while (queue.size() != 1){
            int removedIndex;
            if (m > queue.size()){
                removedIndex = (m-1) % queue.size();
            }else {
                removedIndex = m-1;
            }
            queue.remove(removedIndex);
            if ( (m-1)%(queue.size()+1) == 0 || (m-1)%(queue.size()+1) == queue.size()){
                continue;
            }
            for (int i = 0;i<removedIndex;i++){
                queue.add(queue.poll());
            }
        }
        return queue.poll();
    }
}

package SwordToOffer.NK33.GetUglyNumber_Solution________________;

public class Main {
    public static void main(String[] args) {
        long startTime=System.nanoTime();
        Solution solution = new Solution();
        System.out.println(solution.GetUglyNumber_Solution(12));
        long endTime=System.nanoTime(); //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ns");
    }
}

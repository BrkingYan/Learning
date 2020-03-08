package SwordToOffer.NK33.GetUglyNumber_Solution________________;

public class Main {
    public static void main(String[] args) {
        long startTime=System.nanoTime();
        Solution solution = new Solution();
        System.out.println(solution.GetUglyNumber_Solution(12));
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
}

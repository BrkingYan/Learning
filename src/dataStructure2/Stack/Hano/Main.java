package dataStructure2.Stack.Hano;

public class Main {
    private static int count = 0;
    private static final int plateNum = 5;
    public static void main(String[] args) {
        hanoi(plateNum,1,2,3);
    }

    //这个函数的功能是把p1中的所有盘子移动到p3中
    static void hanoi(int n,int p1,int p2,int p3){
        if (n == 1){
            count++;
            System.out.println("将" + p1 + "中最上面的盘子移动到" + p3 + "中" + "    当前移动了" + count + "次");
        }else {
            //先把上面n-1个从p1移动到p2
            hanoi(n-1,p1,p3,p2);
            //再把p1中最大的盘子移动到p3
            count++;
            System.out.println("将" + p1 + "中最上面的盘子移动到" + p3 + "中" + "    当前移动了" + count + "次");
            //最后把p2中的n-1个移动到p3
            hanoi(n-1,p2,p1,p3);
        }
    }
}

package SwordToOffer.NK7.fabulaci;

/*
* ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
n<=39
* */
public class Solution2 {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}

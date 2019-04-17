package D_Algorithm4th.Chapter1;

class Euclidean {
    /**
     * ŷ������㷨�����Լ��
     * ������������֪��������0Ϊֹ�����ķ������������������
     * @param m
     * @param n
     * @return
     */
    static int gcd(int m, int n) {
        while (n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * ŷ������㷨�����Լ��
     * �ݹ�ʵ��
     */
    static long gcdRecursive(int a, int b) {
        if (b == 0){
            return a;
        }
        int res = a % b;
        return gcd(b,res);

    }

}

package D_Algorithm4th.Chapter1;

class Euclidean {
    /**
     * 欧几里得算法求最大公约数
     * 连续计算余数知道余数是0为止，最后的非零余数就是最大公因数
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
     * 欧几里得算法求最大公约数
     * 递归实现
     */
    static long gcdRecursive(int a, int b) {
        if (b == 0){
            return a;
        }
        int res = a % b;
        return gcd(b,res);

    }

}

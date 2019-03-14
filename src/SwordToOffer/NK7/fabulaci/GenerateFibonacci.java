package SwordToOffer.NK7.fabulaci;


class GenerateFibonacci {
    public int[] genFibonacciList(int n){
        if (n < 0){
            throw new ArrayIndexOutOfBoundsException("输入的长度不合法");
        }else if (n < 2){
            int[] array = new int[n + 1];
            for (int i = 0;i < n+1;i++){
                array[i] = i;
            }
            return array;
        }else {
            int[] array = new int[n + 1];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2;i <= n;i++){
                array[i] = array[i-1] + array[i-2];
            }
            return array;
        }
    }

}

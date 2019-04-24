package SwordToOffer.NK45.isContinuous;

/*
 *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54 张^_^)...
 * 他随机从中抽出了5 张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。
 *
 * 为了方便起见,你可以认为大小王是0。
 * */
class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0){
            return false;
        }
        sort(numbers,0,numbers.length-1);
        int zeroCount = 0;
        for (int e : numbers){
            if (e == 0){
                zeroCount++;
            }
        }
        for (int i = zeroCount;i<numbers.length-1;i++){
            int minus = numbers[i+1] - numbers[i];
            if (minus-1 > zeroCount || minus==0){
                return false;
            }
            zeroCount = zeroCount-minus+1;
        }
        return true;
    }

    private void sort(int[] a, int low, int high) {
        int lPointer, rPointer, mark;
        if (low > high) {
            return;
        }
        lPointer = low;
        rPointer = high;
        mark = a[lPointer]; // 用子表的第一个记录做基准
        while (lPointer < rPointer) {
            // 从右向左找第一个小于基准mark的数
            while (lPointer < rPointer && a[rPointer] >= mark)
                rPointer--;
            if (lPointer < rPointer)
                a[lPointer++] = a[rPointer];
            //从左向右找第一个大于基准mark的数
            while (lPointer < rPointer && a[lPointer] < mark)
                lPointer++;
            if (lPointer < rPointer)
                a[rPointer--] = a[lPointer];
        }
        a[lPointer] = mark;// 将基准数值替换回 a[i]
        sort(a, low, lPointer - 1); // 对低子表进行递归排序
        sort(a, lPointer + 1, high); // 对高子表进行递归排序

    }
}

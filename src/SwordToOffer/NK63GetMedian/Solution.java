package SwordToOffer.NK63GetMedian;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
* 那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
* 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
* */
public class Solution {
    //private DataInputStream stream = new DataInputStream();
    private List<Double> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num.doubleValue());
    }

    public Double GetMedian() {
        sort(list);
        if (list.size() % 2 != 0){
            return list.get((list.size()-1)/2);
        }else {
            return (list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        }
    }
    //插入排序
    public void sort(List<Double> list){
        double temp;
        for (int i = 0;i<list.size()-1;i++){
            for (int j = i+1;j>0;j--){
                if (list.get(j-1) > list.get(j)){
                    temp = list.get(j-1);
                    list.set(j-1,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }

}

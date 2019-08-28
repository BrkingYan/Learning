package SwordToOffer.NK41.FindContinuousSequence;

import java.util.*;
public class Solution2 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        ArrayList<Integer> innerList;
        if(sum < 3){
            return totalList;
        }
        int lo = 1;
        int hi = 2;
        int s;
        int limit = sum / 2;
        while(lo < hi){
            innerList  = new ArrayList<>();
            s = (lo + hi) * (hi - lo +1) / 2;
            if(s == sum){
                for(int i = lo;i<=hi;i++){
                    innerList.add(i);
                }
                totalList.add(innerList);
                hi++;
            }else if(s < sum){
                if(hi+1 < limit){
                    hi++;
                }else{
                    break;
                }
            }else{
                lo++;
            }
        }
        return totalList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().FindContinuousSequence(100));
    }
}

package TouTiao;

import java.util.*;
/*
 *1.闹钟个数
  2-4.闹钟响铃时间
  5.从家到学校的时间
  6.上课时间
 *
*/
public class Main{
    private static class Timee implements Comparable<Timee>{
        int hour;
        int min;
        Timee(int hour,int min){
            this.hour = hour;
            this.min = min;
        }
        public int compareTo(Timee other){
            if(this.hour > other.hour){
                return 1;
            }else if(this.hour == other.hour){
                if(this.min == other.min){
                    return 0;
                }else if(this.min > other.min){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Timee> clockList = new ArrayList<>();
        int clockNum = sc.nextInt();
        Timee temp;
        //所有闹钟
        for(int i = 0;i<clockNum;i++){
            temp = new Timee(sc.nextInt(),sc.nextInt());
            clockList.add(temp);
        }
        //路程时间
        int pathMin = sc.nextInt();
        int pathHour = 0;
        if(pathMin >= 60){
            pathHour = 1;
            pathMin = pathHour - 60;
        }
        Timee pathTime = new Timee(pathHour,pathMin);
        //上课时间
        Timee classTime = new Timee(sc.nextInt(),sc.nextInt());
        //最晚起床时间
        int wakeupHour = classTime.hour - pathTime.hour;
        int wakeupMin = classTime.min - pathTime.min;
        if(wakeupMin < 0){
            wakeupMin += 60;
            wakeupHour += 1;
        }
        if(wakeupHour <= 0){
            wakeupHour = wakeupHour + 24;
        }
        Timee wakeupTime = new Timee(wakeupHour,wakeupMin);
        //寻找最晚闹钟
        Collections.sort(clockList);
        Timee properTime = null;
        for(int i = 0;i < clockList.size();i++){
            if(clockList.get(i).compareTo(wakeupTime) > 0){
                if(i >= 1){
                    properTime = clockList.get(i-1);
                    break;
                }
            }
        }
        System.out.print(properTime.hour + " " + properTime.min);
    }
}

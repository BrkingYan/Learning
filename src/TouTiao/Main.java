package TouTiao;

import java.util.*;
/*
 *1.���Ӹ���
  2-4.��������ʱ��
  5.�Ӽҵ�ѧУ��ʱ��
  6.�Ͽ�ʱ��
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
        //��������
        for(int i = 0;i<clockNum;i++){
            temp = new Timee(sc.nextInt(),sc.nextInt());
            clockList.add(temp);
        }
        //·��ʱ��
        int pathMin = sc.nextInt();
        int pathHour = 0;
        if(pathMin >= 60){
            pathHour = 1;
            pathMin = pathHour - 60;
        }
        Timee pathTime = new Timee(pathHour,pathMin);
        //�Ͽ�ʱ��
        Timee classTime = new Timee(sc.nextInt(),sc.nextInt());
        //������ʱ��
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
        //Ѱ����������
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

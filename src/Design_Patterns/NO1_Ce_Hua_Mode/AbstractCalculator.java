package Design_Patterns.NO1_Ce_Hua_Mode;

public  abstract class AbstractCalculator {       //辅助类，用于实现一部分功能给其他子类使用
    public int[] spit(String exp,String opt){

        String array[] = exp.split(opt);
        int [] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }

}

package Design_Patterns.NO1_Ce_Hua_Mode;



/*
* 策略模式定义了算法族，分别封装起来，让他们之间可以互相替换，
* 此模式让算法的变化独立于使用算法的客户
* */
public class Test {
    public static void main(String[] args){
        String exp = "8-2";
        Calculator c1 = new Minus();
        int result1 = c1.calculate(exp);
        System.out.println(result1);

        String exp1 = "8+2";
        Calculator c2 = new Plus()  ;
        int result2 = c2.calculate(exp1);
        System.out.println(result2);

        String exp2 = "8*2";
        Calculator c3 = new Multiply();
        int result3 = c3.calculate(exp2);
        System.out.println(result3);


    }
}

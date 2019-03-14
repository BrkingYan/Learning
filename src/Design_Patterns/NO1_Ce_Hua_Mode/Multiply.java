package Design_Patterns.NO1_Ce_Hua_Mode;

 class Multiply extends AbstractCalculator implements Calculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = spit(exp,"\\*");
        return arrayInt[0] * arrayInt[1];
    }
}

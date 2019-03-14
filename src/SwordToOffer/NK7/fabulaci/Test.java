package SwordToOffer.NK7.fabulaci;

public class Test {
    public static void main(String[] args){
        GenerateFibonacci generateFibonacci = new GenerateFibonacci();
        int[] array = generateFibonacci.genFibonacciList(7);
        for (int element : array){
            System.out.println(element);
        }
        System.out.println("----------------");

        Solution solution = new Solution();
        int element = solution.Fibonacci(6);
        System.out.println(element);
    }
}

package D_Algorithm4th.Chapter1;

public class CalculateMathExpression {

    private static double calculateInFix(String s){
        char[] expression = s.toCharArray();
        Stack<Character> operators = new Stack<>();
        Stack<Double> values = new Stack<>();

        for (int i = 0;i<expression.length;i++){
            char ch = expression[i];
            switch (ch){
                case '(':
                    break;
                case '+':
                    operators.push(ch);
                    break;
                case '-':
                    operators.push(ch);
                    break;
                case '*':
                    operators.push(ch);
                    break;
                case '/':
                    operators.push(ch);
                    break;
                case ')':{
                    double result = 0;
                    double val1 = values.pop();
                    char op = operators.pop();
                    switch (op){
                        case '+':
                            result = values.pop() + val1;
                            break;
                        case '-':
                            result = values.pop() - val1;
                            break;
                        case '*':
                            result = values.pop() * val1;
                            break;
                        case '/':
                            result = values.pop() / val1;
                            break;
                    }
                    values.push(result);
                    break;
                }
                default:
                    values.push(Double.parseDouble(ch+""));
            }
        }
        return values.pop();
    }

    private static double calculatePostFix(String s){
        char[] expression = s.toCharArray();
        Stack<Character> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int i = 0;i<expression.length;i++){
            char ch = expression[i];
            double result = 0;
            switch (ch){
                case '+':
                    double val1 = values.pop();
                    result = values.pop() + val1;
                    values.push(result);
                    break;
                case '-':
                    double val2 = values.pop();
                    result = values.pop() - val2;
                    values.push(result);
                    break;
                case '*':
                    double val3 = values.pop();
                    result = values.pop() * val3;
                    values.push(result);
                    break;
                case '/':
                    double val4 = values.pop();
                    result = values.pop() / val4;
                    values.push(result);
                    break;
                default:
                    values.push(Double.parseDouble(ch+""));
                    break;
            }
        }
        return values.pop();
    }

    private static double calculatePreFix(String s){
        char[] expression = s.toCharArray();
        Stack<Double> values = new Stack<>();
        for (int i = expression.length-1;i>=0;i--){
            char ch = expression[i];
            switch (ch){
                case '+':
                    double result1 = values.pop() + values.pop();
                    values.push(result1);
                    break;
                case '-':
                    double result2 = values.pop() - values.pop();
                    values.push(result2);
                    break;
                case '*':
                    double result3 = values.pop() * values.pop();
                    values.push(result3);
                    break;
                case '/':
                    double result4 = values.pop() / values.pop();
                    values.push(result4);
                    break;
                default:
                    values.push(Double.parseDouble(ch+""));
                    break;
            }
        }
        return values.pop();
    }

    static String transInToPre(String in){
        return "";
    }

    static String transInToPost(String in){
        return "";
    }

    public static void main(String[] args) {
        System.out.println(calculateInFix("((3+4)+(3*(5+6))+(6/(2-1))))"));
        System.out.println(calculatePostFix("629*3/+42*+8-"));
        System.out.println(calculatePreFix("-++6/*293*428"));
    }
}

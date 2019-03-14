package Design_Patterns.NO8_template_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    public boolean customWantsCondiments(){
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")){
            return true;
        }
        else
            return false;
    }
    //该方法询问用户是否需要糖或者牛奶，通过命令行得到用户输入
    public String getUserInput(){
        String answer = null;
        System.out.println("Would you like a lemon with your coffee (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null)
            return "no";
        else
            return answer;
    }
}

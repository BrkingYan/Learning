package Design_Patterns.NO8_template_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }
    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
//根据用户的输入确定是否需要放调料
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
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");

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

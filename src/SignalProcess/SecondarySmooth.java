package SignalProcess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecondarySmooth {
    private static Float getExpect(List<Float> list, int year, Float modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }

        Float modulusLeft = 1 - modulus;

        Float lastIndex = list.get(0);
        Float lastSecIndex = list.get(0);

        for (Float data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            lastSecIndex = modulus * lastIndex + modulusLeft * lastSecIndex;
        }

        Float a = 2 * lastIndex - lastSecIndex;
        Float b = (modulus / modulusLeft) * (lastIndex - lastSecIndex);

        return a + b * year;
    }

    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/SignalProcess/out.txt"));
            reader = new BufferedReader(new FileReader("src/SignalProcess/gg0.txt"));
            String line;
            //加入输入数据
            List<Float> inputList = new ArrayList<>();
            while ((line = reader.readLine())!=null){
                String[] ss = line.split("\t");
                inputList.add(Float.parseFloat(ss[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

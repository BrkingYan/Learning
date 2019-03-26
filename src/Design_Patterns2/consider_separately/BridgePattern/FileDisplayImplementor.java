package Design_Patterns2.consider_separately.BridgePattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileDisplayImplementor implements DisplayImplementor {

    private FileReader fr = null;
    private BufferedReader bfr = null;
    private String fileName;

    FileDisplayImplementor(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void rawOpen() {
        printLine();

    }

    @Override
    public void rawPrint() {
        try {
            fr = new FileReader(fileName);
            bfr = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = bfr.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void rawClose() {

        printLine();
    }

    private void printLine(){
        System.out.println("-------------------- file ---------------------");
    }
}

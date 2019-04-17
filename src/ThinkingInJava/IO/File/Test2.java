package ThinkingInJava.IO.File;


import java.io.*;
import java.util.regex.Pattern;

public class Test2 {

    private static FilenameFilter getFilter(String regex){
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File file = new File(".");
        String[] list = file.list(getFilter(args[0]));
        for (String f : list){
            System.out.println(f);
        }

    }
}

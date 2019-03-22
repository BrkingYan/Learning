package Design_Patterns2.generate_instance.BuilderPattern;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        *  用字符缓冲流包装标准输入流来获取键盘输入
        * */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("请输入编写文档的方式:");
            try {
                Loop:
                while ((line = reader.readLine()) != null) {
                    switch (line) {
                        case "plain": {
                            TextBuilder textBuilder = new TextBuilder();
                            Director director = new Director(textBuilder);
                            director.construct();
                            String result = textBuilder.getResult();
                            System.out.println(result);
                            System.out.println("纯文本编写完成!");
                            break Loop;
                        }
                        case "html": {
                            HtmlBuilder htmlBuilder = new HtmlBuilder("test111");
                            Director director = new Director(htmlBuilder);
                            director.construct();
                            String fileName = htmlBuilder.getResult();
                            System.out.println(fileName + " 文件编写完成");
                            System.out.println("是否读取文件内容? yes/no");
                            String newLine;
                            while ((newLine = reader.readLine()) != null){
                                if (newLine.equals("yes")){
                                    FileReader fr = new FileReader(fileName);
                                    BufferedReader bfr = new BufferedReader(fr);
                                    String fileLine;
                                    while ((fileLine = bfr.readLine()) != null){
                                        System.out.println(fileLine);
                                    }
                                    break;
                                }else if (newLine.equals("no")){
                                    break;
                                }else {
                                    System.out.println("请输入yes或者no");
                                }
                            }
                            break Loop;
                        }
                        case "exit":
                            break Loop;
                        default:
                            System.out.println("输入格式不对,请重新输入:");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                    System.out.println("reader 关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        /*
        *  用Scanner的方式获取键盘输入
        * */
        /*****************************************************
        Scanner in = new Scanner(System.in);
        System.out.println("请输入编写文档的方式:");
        loop1:
        while (true){
            String inputText = in.nextLine();
            if (inputText.equals("plain")){
                TextBuilder textBuilder = new TextBuilder();
                Director director = new Director(textBuilder);
                director.construct();
                String result = textBuilder.getResult();
                System.out.println(result);
                System.out.println("纯文本编写完成!");
                break;
            }else if (inputText.equals("html")){
                HtmlBuilder htmlBuilder = new HtmlBuilder("test111");
                Director director = new Director(htmlBuilder);
                director.construct();
                String fileName = htmlBuilder.getResult();
                System.out.println(fileName + " 文件编写完成");
                System.out.println("是否读取文件内容? yes/no");
                while (true){
                    String inputText2 = in.nextLine();
                    if (inputText2.equals("yes")){
                        FileReader fr;
                        BufferedReader bfr = null;
                        try {
                            fr = new FileReader(fileName);
                            bfr = new BufferedReader(fr);
                            String line;
                            while ((line = bfr.readLine()) != null){
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                if (bfr != null)
                                    bfr.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("读取文件成功");
                        break loop1;
                    }else if (inputText2.equals("no")){
                        break loop1;
                    }else {
                        System.out.println("请输入yes或者no");
                    }
                }
            }else {
                System.out.println("你输入的是: " + inputText + "  输入的方式不对,请重新输入:");
            }
        }
*****************************************************************************/

        /*
        *  用main函数的args参数获取键盘输入参数
        * */

/*
        if (args.length != 1){
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")){
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        }else if (args[0].equals("html")){
            HtmlBuilder htmlBuilder = new HtmlBuilder("test111");
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + " 文件编写完成");
        }else {
            usage();
            System.exit(0);
        }
        */
    }

    public static void usage(){
        System.out.println("Usage: java Main plain      编写纯文本文档");
        System.out.println("Usage: java Main html       编写html文档");
    }
}

package Design_Patterns2.generate_instance.BuilderPattern;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        *  ���ַ���������װ��׼����������ȡ��������
        * */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("�������д�ĵ��ķ�ʽ:");
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
                            System.out.println("���ı���д���!");
                            break Loop;
                        }
                        case "html": {
                            HtmlBuilder htmlBuilder = new HtmlBuilder("test111");
                            Director director = new Director(htmlBuilder);
                            director.construct();
                            String fileName = htmlBuilder.getResult();
                            System.out.println(fileName + " �ļ���д���");
                            System.out.println("�Ƿ��ȡ�ļ�����? yes/no");
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
                                    System.out.println("������yes����no");
                                }
                            }
                            break Loop;
                        }
                        case "exit":
                            break Loop;
                        default:
                            System.out.println("�����ʽ����,����������:");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                    System.out.println("reader �ر�");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        /*
        *  ��Scanner�ķ�ʽ��ȡ��������
        * */
        /*****************************************************
        Scanner in = new Scanner(System.in);
        System.out.println("�������д�ĵ��ķ�ʽ:");
        loop1:
        while (true){
            String inputText = in.nextLine();
            if (inputText.equals("plain")){
                TextBuilder textBuilder = new TextBuilder();
                Director director = new Director(textBuilder);
                director.construct();
                String result = textBuilder.getResult();
                System.out.println(result);
                System.out.println("���ı���д���!");
                break;
            }else if (inputText.equals("html")){
                HtmlBuilder htmlBuilder = new HtmlBuilder("test111");
                Director director = new Director(htmlBuilder);
                director.construct();
                String fileName = htmlBuilder.getResult();
                System.out.println(fileName + " �ļ���д���");
                System.out.println("�Ƿ��ȡ�ļ�����? yes/no");
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
                        System.out.println("��ȡ�ļ��ɹ�");
                        break loop1;
                    }else if (inputText2.equals("no")){
                        break loop1;
                    }else {
                        System.out.println("������yes����no");
                    }
                }
            }else {
                System.out.println("���������: " + inputText + "  ����ķ�ʽ����,����������:");
            }
        }
*****************************************************************************/

        /*
        *  ��main������args������ȡ�����������
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
            System.out.println(fileName + " �ļ���д���");
        }else {
            usage();
            System.exit(0);
        }
        */
    }

    public static void usage(){
        System.out.println("Usage: java Main plain      ��д���ı��ĵ�");
        System.out.println("Usage: java Main html       ��дhtml�ĵ�");
    }
}

package AliTest;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\test.txt";
        HashMap<String,Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        int temp;
        char ch;
        while (true){
            temp = reader.read();
            if (temp == -1){
                hashToFile(sb.toString());//�����ַ���ӳ�䵽��Ӧ�ļ���
                break;
            }else if ((char)temp == ' '){
                hashToFile(sb.toString());
                sb.delete(0,sb.length());
                continue;
            }
            sb.append((char)temp);
        }
    }

    //���ַ�������hashֵӳ�䵽��Ӧ�ļ�
    public static void hashToFile(String str) throws IOException {
        char[] arr = str.toCharArray();
        int index = 0;
        int i=0;
        while(i<arr.length) {
            index += index * 31 + arr[i];
            i++;
        }
        int hash = index % 5000;
        String fileName = "out" + hash + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        writer.write(str);
        writer.write(" ");
    }

    //����ÿ��С�ļ��г��������ַ������������
    private static ArrayList<String> list = new ArrayList<>();
    private static void calFreq() throws IOException {
        //��out1.txtΪ��
        BufferedReader reader = new BufferedReader(new FileReader("out1.txt"));
        String s = reader.readLine();
        String[] ss = s.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        String maxStr = null;
        for (String e : ss){
            map.put(e,map.getOrDefault(e,0));
            if (map.get(e) > max){
                max = map.get(e);
                maxStr = e;
            }
        }
        //�����ļ��еĳ������ε��ַ������뵽�ܵ�list��
        list.add(max,maxStr);
    }
}

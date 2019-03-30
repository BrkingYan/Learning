package dataStructure2.Unidirectional_LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input info : ");
        StudentList list = new StudentList();
        int count = 3;
        while (count-- > 0){
            try {
                System.out.println("-------------------------");
                System.out.println("input id : ");
                String id = br.readLine();
                System.out.println("input name : ");
                String name = br.readLine();
                System.out.println("input age : ");
                String age = br.readLine();
                Student s = new Student(Integer.parseInt(id),name,Integer.parseInt(age));
                list.add(s);
                System.out.println("--------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.toString());
    }
}

package ThinkingInJava.Collection;

import com.sun.istack.internal.NotNull;

import java.util.*;

class DetailForArrayList {
    public static void main(String[] args) {
        /*String[] words = "And that is how we know the Earth to be banana-shaped".split(" ");
        List<String> list = Arrays.asList(words);// list = new ArrayList(words);
        //����һ��list�����words,
        //��һ��ֱ�Ӱ�words����list���������ã�list.elementData = words.toArray();
        //�����ǽ�c��Ԫ�ؿ�����������˸ı�list�����൱�ڸı�elementData��Ҳ���൱�ڸı�words


        System.out.println(words);
        System.out.println(list.toArray());//liar.toArray()������һ��������
        String[] newWords = (String[]) list.toArray();
        newWords[0] = "haha";//�ı���������鲻��Ӱ��ԭ����
        System.out.println(words[0]);

        *//*
        *  �ı� list ��Ӱ��ԭ����
        * *//*
        System.out.println(list);
        String temp = list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
        System.out.println(list);
        System.out.println(words);*/
        //����һ���ַ�������
        String[] words = "And that is how we know the Earth to be banana-shaped".split(" ");
        //��������ͨ��Arrays.asList������ͨ��ArrayList�Ĺ��������ݸ���list
        //List<String> list = Arrays.asList(words);// list = new ArrayList(words);
        List<String> list = new ArrayList<>();
        Collections.addAll(list,words);

        System.out.println("list�ı�ǰ����ĵ�һ��Ԫ�� : " + words[0]);
        System.out.println("list�ı�ǰ��list" + list);
        //�������������ͬ

        /*
         *  �ı� list ��Ӱ��ԭ����
         * */
        //��list�е�Ԫ�ػ�λ
        String temp = list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
        System.out.println("list�ı���list" + list);
        System.out.println("list�ı������ĵ�һ��Ԫ�� : " + words[0]);


        //print(words);
    }

    /*private static List<String> print(@NotNull String... s){
        //List<String> list = new ArrayList<String>(s);

    }*/
}

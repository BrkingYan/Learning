package ThinkingInJava.Collection;

import com.sun.istack.internal.NotNull;

import java.util.*;

class DetailForArrayList {
    public static void main(String[] args) {
        /*String[] words = "And that is how we know the Earth to be banana-shaped".split(" ");
        List<String> list = Arrays.asList(words);// list = new ArrayList(words);
        //创建一个list来存放words,
        //这一步直接把words给了list的数组引用，list.elementData = words.toArray();
        //而不是将c中元素拷贝进来，因此改变list，就相当于改变elementData，也就相当于改变words


        System.out.println(words);
        System.out.println(list.toArray());//liar.toArray()产生了一个新数组
        String[] newWords = (String[]) list.toArray();
        newWords[0] = "haha";//改变这个新数组不会影响原数组
        System.out.println(words[0]);

        *//*
        *  改变 list 会影响原数组
        * *//*
        System.out.println(list);
        String temp = list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
        System.out.println(list);
        System.out.println(words);*/
        //创建一个字符串数组
        String[] words = "And that is how we know the Earth to be banana-shaped".split(" ");
        //将该数组通过Arrays.asList方法，通过ArrayList的构造器传递给该list
        //List<String> list = Arrays.asList(words);// list = new ArrayList(words);
        List<String> list = new ArrayList<>();
        Collections.addAll(list,words);

        System.out.println("list改变前数组的第一个元素 : " + words[0]);
        System.out.println("list改变前的list" + list);
        //上面两个结果相同

        /*
         *  改变 list 会影响原数组
         * */
        //将list中的元素换位
        String temp = list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
        System.out.println("list改变后的list" + list);
        System.out.println("list改变后数组的第一个元素 : " + words[0]);


        //print(words);
    }

    /*private static List<String> print(@NotNull String... s){
        //List<String> list = new ArrayList<String>(s);

    }*/
}

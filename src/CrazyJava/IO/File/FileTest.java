package CrazyJava.IO.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径创建一个File对象  其实是根目录
        File file = new File(".");//  .表示当前路径
        //获取文件名
        System.out.println(file.getName());
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取相对路径的父目录
        System.out.println(file.getParent());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tempFile = File.createTempFile("aaa",".txt",file);
        //指定JVM退出时删除该文件
        tempFile.deleteOnExit();
        //以系统当前时间为文件名创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("新文件是否存在 ： " + newFile.exists());
        //以指定newFile对象创建一个新文件
        newFile.createNewFile();
        //以newFile对象创建一个目录
        newFile.mkdir();
        //使用list方法列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("=====当前路径下所有文件和路径如下：====");
        for (String fileName : fileList){
            System.out.println(fileName);
        }
        // listRoots方法列出所有的磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("=====系统所有根路径如下: =====");
        for (File root : roots){
            System.out.println(root);
        }



    }
}

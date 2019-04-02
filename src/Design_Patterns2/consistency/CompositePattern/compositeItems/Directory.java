package Design_Patterns2.consistency.CompositePattern.compositeItems;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {

    private String name;
    private ArrayList<Entry> entries;

    public Directory(String name){
        this.name = name;
        entries = new ArrayList<>();
        this.grade = 1;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        Iterator<Entry> it = entries.iterator();
        int size = 0;
        while (it.hasNext()){
            Entry entry = it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String parentDir) {
        //先打印整个目录的情况
        System.out.println(parentDir + "/" + this);
        //再依次打印目录内部的情况
        //System.out.print("      |");
        Iterator<Entry> it = entries.iterator();
        while (it.hasNext()){
            Entry entry = it.next();
            for (int i = 0;i < entry.grade;i++){
                System.out.print("_______");
            }
            //System.out.print("directory details : ");
            //打印父文件的目录
            entry.printList(parentDir + "/" + name);
        }
    }


    /*
    它继承了这个方法
    //这个方法是外界用的
    public void printList(){
        printList("");
    }
*/

    @Override
    public void add(Entry entry) {
        entry.grade += this.grade;
        entries.add(entry);
        entry.parent = this;
    }
}

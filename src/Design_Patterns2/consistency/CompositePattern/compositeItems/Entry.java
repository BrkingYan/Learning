package Design_Patterns2.consistency.CompositePattern.compositeItems;


/*
*  该类是一致性的关键，将File(内容) 和Directory(容器) 都当作Entry处理
* */
public abstract class Entry {

    int grade;//层级

    abstract String getName();
    abstract int getSize();
    abstract void printList(String parentDir);

    //这个方法是外界用的
    public void printList(){
        printList("");
    }

    public void add(Entry entry) throws FileTreatmentException{
        //规定不能向File中添加文件或文件夹
        if (entry.getClass().getSimpleName().equals("File"))
            throw new FileTreatmentException("不能向文件中添加文件");
        else if (entry.getClass().getSimpleName().equals("Directory"))
            throw new FileTreatmentException("不能向文件中添加文件夹");
    }

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

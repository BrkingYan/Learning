package Design_Patterns2.consistency.CompositePattern.compositeItems;

public class File extends  Entry {

    private String name;
    private int size;

    public File(String name,int size){
        this.name = name;
        this.size = size;
        this.grade = 1;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    // File 的 printList方法
    @Override
    protected void printList(String parentDir) {
        System.out.println(parentDir + "/" + this);//只有File的print方法真正打印了东西，其他的最终会去调用File的该方法
    }

    /*@Override
    void add(Entry entry) throws FileTreatmentException {
        super.add(entry);
    }*/

    /*
    它继承了这个方法
    //这个方法是外界用的
    public void printList(){
        printList("");
    }
*/

}

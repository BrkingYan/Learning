package Design_Patterns2.GiveToSubClass.Template_Method;


// 模板类，提供模板方法，说明了先干什么再干什么，但并没具体实现
// 父类指挥子类按一定算法执行
abstract class AbstractDisplay {
    abstract void open();
    abstract void print();
    abstract void close();

    //模板算法 ，用final上锁，防止之类覆盖或更改
    final void display(){
        open();
        for (int i = 0;i < 5;i++){
            print();
        }
        close();
    }
}

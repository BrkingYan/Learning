package Design_Patterns2.GiveToSubClass.Template_Method;


// ģ���࣬�ṩģ�巽����˵�����ȸ�ʲô�ٸ�ʲô������û����ʵ��
// ����ָ�����ఴһ���㷨ִ��
abstract class AbstractDisplay {
    abstract void open();
    abstract void print();
    abstract void close();

    //ģ���㷨 ����final��������ֹ֮�า�ǻ����
    final void display(){
        open();
        for (int i = 0;i < 5;i++){
            print();
        }
        close();
    }
}

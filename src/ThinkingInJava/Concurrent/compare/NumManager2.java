package ThinkingInJava.Concurrent.compare;

class NumManager2 extends NumManager {

    /*
     *  ���Number��ͬ�����������ͬ��Ҳû����
     *  ��Ϊ�������ջ���Ҫ����Number
     * */
    void increment(){
        synchronized (this){
            number.increment();
        }
    }

}

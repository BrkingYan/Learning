package ThinkingInJava.Concurrent.Atomic;

/*
*  ������������
* */
class NumGenerator  {
    private static volatile int number = 0;
    static int nextNumber(){
        return number++;     //��ԭ�Ӳ���
    }
    /*
    * ��Ȼvolatile���Ա�֤number���޸�֮������д���ڴ�
    * ����nextNumber()�����ǲ�ͬ���ģ�
    * �����߳�
    * */
}

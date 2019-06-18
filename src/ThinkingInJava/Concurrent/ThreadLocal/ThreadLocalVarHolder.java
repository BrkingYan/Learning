package ThinkingInJava.Concurrent.ThreadLocal;

import java.util.Map;
import java.util.Random;

/*
*  ���AddTask�����������ThreadLocalVarHolder
* */
class ThreadLocalVarHolder {
    /*
    *  ThreadLocal��װ����TaskInfo����
    *  ��ʹAddTaskû�г���TaskInfo����ThreadLocalҲ�������ڲ���ThreadLocal.Map��AddTask(current thread)��TaskInfo������
    *  ʹ��ThreadLocal�����ı���ֻ�ܱ���ǰ�̷߳��ʣ������߳����޷����ʺ��޸ġ�
    *  ÿ������ ThreadLocal �������̶߳����Լ���һ�������ء�TaskInfoʵ������
    * */
    private static ThreadLocal<TaskInfo> value = new ThreadLocal<TaskInfo>(){
        private Random rand = new Random(47);

        @Override
        protected TaskInfo initialValue() {
            //��ʵ������ThreadLocal����valueΪ��ͬ�߳�������ɵ�TaskInfo "����" ʵ��
            return new TaskInfo(rand.nextInt(10000),0);
        }

        /*int getValue(){
            TaskInfo info = value.get();
            return info.getVal();
        }

        void setValue(int val){
            TaskInfo info = value.get();
            info.setVal(val);
        }

        int getCount(){
            TaskInfo info = value.get();
            return info.getCount();
        }

        void setCount(int count){
            TaskInfo info = value.get();
            info.setCount(count);
        }*/
    };

    static void increment(){
        TaskInfo temp = value.get();
        temp.setCount(temp.getCount() + 1);
        temp.setVal(temp.getVal() + 1);
        value.set(temp);
    }

    static TaskInfo getValue(){
        return value.get();//���ش��ֲ߳̾������ĵ�ǰ�̸߳����е�ֵ��
    }

}

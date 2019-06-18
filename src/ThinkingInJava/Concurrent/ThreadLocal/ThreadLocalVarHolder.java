package ThinkingInJava.Concurrent.ThreadLocal;

import java.util.Map;
import java.util.Random;

/*
*  多个AddTask任务共享了这个ThreadLocalVarHolder
* */
class ThreadLocalVarHolder {
    /*
    *  ThreadLocal中装的是TaskInfo对象
    *  即使AddTask没有持有TaskInfo对象，ThreadLocal也会让其内部的ThreadLocal.Map将AddTask(current thread)和TaskInfo绑定起来
    *  使用ThreadLocal创建的变量只能被当前线程访问，其他线程则无法访问和修改。
    *  每个访问 ThreadLocal 变量的线程都有自己的一个“本地”TaskInfo实例副本
    * */
    private static ThreadLocal<TaskInfo> value = new ThreadLocal<TaskInfo>(){
        private Random rand = new Random(47);

        @Override
        protected TaskInfo initialValue() {
            //该实例就是ThreadLocal变量value为不同线程随机生成的TaskInfo "本地" 实例
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
        return value.get();//返回此线程局部变量的当前线程副本中的值。
    }

}

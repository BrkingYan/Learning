package ThinkingInJava.InnerClass.CallBackDemo;

class Teacher implements KeJi {

    private Student student;

    /**
     * 老师的构造方法，持有学生的引用
     * @param student
     */
    public Teacher(Student student){
        this.student = student;
    }

    /**
     * 老师通过这个方法去问学生的问题
     * @param question  就是老师要问的问题,1 + 1 = ?
     */
    public void askQuestion(final String question){
        //这里用一个线程就是异步，
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 老师调用学生中的方法，在这里注册回调接口
                 * 这就相当于A类调用B的方法C
                 */
                student.executeMessage(Teacher.this, question);
            }
        }).start();

        //老师问完问题挂掉电话就去干其他的事情了，诳街去了
        play();
    }

    public void play(){
        System.out.println("I'll play outside");
    }

    /**
     * 学生知道答案后调用此方法告诉老师，就是所谓的老师的回调方法
     */
    @Override
    public void showAnswer(String result) {
        System.out.println("student told the answer to teacher --->" + result);
    }
}

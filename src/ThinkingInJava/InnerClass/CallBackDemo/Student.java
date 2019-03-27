package ThinkingInJava.InnerClass.CallBackDemo;

class Student {
    /**
     * @param keJi
     * @param question  老师问的问题
     */
    public void executeMessage(KeJi keJi, String question){
        System.out.println("teacher ask a question --->" + question);

        //模拟学生办自己的事情需要很长时间
        for(int i=0; i<10000;i++){

        }

        /**
         * 学生办完自己的事情之后想到了答案是2
         */
        String result = "answer is 2";

        /**
         * 于是就打电话告诉老师，调用老师中的方法
         * 这就相当于B类反过来调用A的方法D
         */
        keJi.showAnswer(result);
    }
}

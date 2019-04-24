package ThinkingInJava.Concurrent.ThreadLocal;

class TaskInfo {
    private int count;
    private int val;

    TaskInfo(int value,int count){
        this.val = value;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return " info: value-" + val + " count-" + count;
    }
}

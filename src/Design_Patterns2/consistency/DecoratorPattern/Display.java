package Design_Patterns2.consistency.DecoratorPattern;

// Display是装饰者共同的接口
abstract class Display {
    abstract int getColumns();//列数
    abstract int getRows();//行数
    abstract String getRowText(int rowNum);//获取第rowNum行的字符串

    final void show(){
        for (int i = 0;i<getRows();i++){
            System.out.println(getRowText(i));
        }
    }
}

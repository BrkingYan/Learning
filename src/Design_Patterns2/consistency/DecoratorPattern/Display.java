package Design_Patterns2.consistency.DecoratorPattern;

// Display��װ���߹�ͬ�Ľӿ�
abstract class Display {
    abstract int getColumns();//����
    abstract int getRows();//����
    abstract String getRowText(int rowNum);//��ȡ��rowNum�е��ַ���

    final void show(){
        for (int i = 0;i<getRows();i++){
            System.out.println(getRowText(i));
        }
    }
}

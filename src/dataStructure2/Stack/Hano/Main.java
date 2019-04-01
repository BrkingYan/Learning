package dataStructure2.Stack.Hano;

public class Main {
    private static int count = 0;
    private static final int plateNum = 5;
    public static void main(String[] args) {
        hanoi(plateNum,1,2,3);
    }

    //��������Ĺ����ǰ�p1�е����������ƶ���p3��
    static void hanoi(int n,int p1,int p2,int p3){
        if (n == 1){
            count++;
            System.out.println("��" + p1 + "��������������ƶ���" + p3 + "��" + "    ��ǰ�ƶ���" + count + "��");
        }else {
            //�Ȱ�����n-1����p1�ƶ���p2
            hanoi(n-1,p1,p3,p2);
            //�ٰ�p1�����������ƶ���p3
            count++;
            System.out.println("��" + p1 + "��������������ƶ���" + p3 + "��" + "    ��ǰ�ƶ���" + count + "��");
            //����p2�е�n-1���ƶ���p3
            hanoi(n-1,p2,p1,p3);
        }
    }
}

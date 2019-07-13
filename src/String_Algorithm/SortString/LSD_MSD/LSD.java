package String_Algorithm.SortString.LSD_MSD;

/*
*  LSD ��λ���ȵ��ַ�������
*
*  �����Ҫ�������ַ���������ÿ���ַ����ĳ�����ȣ���ô���ʺ���LSD
*
*  ��һ�������֮�������ַ������ǰ��յ�һ���ַ�Ϊ��׼����õ�
*  �ڶ��������֮�������ַ������ǰ��յڶ����ַ�Ϊ��׼����õ�
*                          .
*                          .
*                          .
*  ��i�������֮�������ַ������ǰ��յ�i���ַ�Ϊ��׼����õ�
* */
public class LSD {
    public static void main(String[] args) {
        String[] strings = new String[]{"4PGC938","2IYE230","3CIO720"};
        sort(strings,3);
        for (String s : strings){
            System.out.println(s);
        }
    }

    /*
    * �÷����Ƕ�һȺ�ַ������������ַ���Ϊ��������С����
    * */
    public static void sort(String[] arr,int strLen){
        int N = arr.length;//�������Ԫ�ظ���
        int SUM = 256;// ASCII��ĸ����������еĿ����Եĸ���
        String[] aux = new String[N];

        for (int charIdx = strLen-1;charIdx>=0;charIdx--){  // �Ե�i���ַ�Ϊid������
            int[] count = new int[257];

            //������ֵ�Ƶ��
            // arr[k].charAt(i) ���� ��k���ַ�����λ��Ϊi���ַ���
            // ��һ����λ��Ϊ1���ַ�Ϊ��׼����
            for (int k = 0;k<N;k++){
                count[arr[k].charAt(charIdx)+1] ++; //�ø��ַ���Ƶ�ʼ�1
            }

            //��Ƶ��ת��Ϊ����
            for (int j = 0;j < 256;j++){
                count[j+1] += count[j];
            }

            //��Ԫ�ط���
            for (int strIdx = 0;strIdx < N;strIdx++){
                aux[count[arr[strIdx].charAt(charIdx)]++] = arr[strIdx];
            }

            //��д
            for (int i = 0;i<arr.length;i++){
                arr[i] = aux[i];
            }
        }
    }
}

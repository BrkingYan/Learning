package String_Algorithm.SortString.LSD_MSD;

/*
*  LSD 低位优先的字符串排序
*
*  如果需要排序多个字符串，并且每个字符串的长度相等，那么就适合用LSD
*
*  第一轮排序好之后，所有字符串就是按照第一个字符为标准排序好的
*  第二轮排序好之后，所有字符串就是按照第二个字符为标准排序好的
*                          .
*                          .
*                          .
*  第i轮排序好之后，所有字符串就是按照第i个字符为标准排序好的
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
    * 该方法是对一群字符串进行排序，字符串为操作的最小对象
    * */
    public static void sort(String[] arr,int strLen){
        int N = arr.length;//待排序的元素个数
        int SUM = 256;// ASCII码的个数，即所有的可能性的个数
        String[] aux = new String[N];

        for (int charIdx = strLen-1;charIdx>=0;charIdx--){  // 以第i个字符为id来排序
            int[] count = new int[257];

            //计算出现的频率
            // arr[k].charAt(i) 代表 第k个字符串的位置为i的字符，
            // 第一轮以位置为1的字符为标准排序
            for (int k = 0;k<N;k++){
                count[arr[k].charAt(charIdx)+1] ++; //让该字符的频率加1
            }

            //将频率转换为索引
            for (int j = 0;j < 256;j++){
                count[j+1] += count[j];
            }

            //将元素分类
            for (int strIdx = 0;strIdx < N;strIdx++){
                aux[count[arr[strIdx].charAt(charIdx)]++] = arr[strIdx];
            }

            //回写
            for (int i = 0;i<arr.length;i++){
                arr[i] = aux[i];
            }
        }
    }
}

package AliTest;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        // ������������
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[arr.length];

        // ���Ϊsum�����������
        search(arr, visited, 0, 0, 8, lists);
        System.out.println(lists);
        System.out.println(lists.size());
    }

    // ��������[curIdx,arr.length-1]��Χ�ڵĺ�Ϊ��ֵ������������
    public static void search(int[] arr, boolean[] visited, int curIdx, int sum, int target,
                                 ArrayList<ArrayList<Integer>> results) {
        //�ﵽĿ�꣬�ͽ���ǰ������ӵ������
        if (sum == target) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= curIdx; j++) {
                if (visited[j]) {
                    list.add(arr[j]);
                }
            }
            results.add(list);
            return;
        }

        //����ȥ�����Ԫ������Ѱ
        for (int i = curIdx; i < arr.length; i++) {
            if (!visited[i]) {
                sum += arr[i];
                visited[i] = true;
                if (i != arr.length - 1) {
                    search(arr, visited, i + 1, sum, target, results);
                } else {
                    search(arr, visited, i, sum, target, results);
                }

                //
                visited[i] = false;
                sum -= arr[i];

                // ��ȵ�Ԫ��ֻͳ��һ��
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
    }
}

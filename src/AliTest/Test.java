package AliTest;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        // 数组升序排序
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[arr.length];

        // 求和为sum的所有组合数
        search(arr, visited, 0, 0, 8, lists);
        System.out.println(lists);
        System.out.println(lists.size());
    }

    // 求数组中[curIdx,arr.length-1]范围内的和为定值的所有子序列
    public static void search(int[] arr, boolean[] visited, int curIdx, int sum, int target,
                                 ArrayList<ArrayList<Integer>> results) {
        //达到目标，就将当前序列添加到结果集
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

        //否则去后面的元素中搜寻
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

                // 相等的元素只统计一次
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
    }
}

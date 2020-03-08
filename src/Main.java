import java.util.*;
import java.io.*;

/*
* 4 4
* 1 1 1 2
* 2 2 2 2
* 3 2 3 2
* 3 3 3 3
*
* */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int cur;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c;j++){
                cur = arr[i][j];
                if (visited[i][j]){
                    continue;
                }
                curCnt = 0;
                dfs(arr,i,j,r,c,cur,visited);
                if (map.containsKey(cur)){
                    int temp = map.get(cur);
                    if (curCnt > temp){
                        map.put(cur,curCnt);
                    }
                }else{
                    map.put(cur,curCnt);
                }
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(a-b));
        TreeMap<Integer,Integer> ret = new TreeMap<>();
        PriorityQueue<Map.Entry> q = new PriorityQueue<>((a,b)->((Integer) b.getValue()-(Integer) a.getValue()));
        for (Map.Entry e : map.entrySet()){
             q.add(e);
        }

        while (!q.isEmpty()){
            System.out.print(q.poll().getKey() + " ");
        }
    }

    private static int curCnt;
    private static void dfs(int[][] arr,int r,int c,int nr,int nc,int target,boolean[][] visited){
        if (r < 0 || r >= nr || c < 0 || c >= nc || arr[r][c] != target || visited[r][c]){
            return;
        }
        visited[r][c] = true;
        curCnt++;
        dfs(arr,r+1,c,nr,nc,target,visited);
        dfs(arr,r-1,c,nr,nc,target,visited);
        dfs(arr,r,c+1,nr,nc,target,visited);
        dfs(arr,r,c-1,nr,nc,target,visited);
    }

}
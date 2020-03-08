package Graph.leetcode;

import Design_Patterns.NO4_Factory_Mode.Pizza;

import java.util.*;
class Solution {

    private class Point{
        int x;
        int y;
        int val;
        Point(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] res = new int[r][c];
        Point[][] mat = new Point[r][c];
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c;j++){
                mat[i][j] = new Point(i,j,matrix[i][j]);
            }
        }
        ArrayList<Point>[][] bags = new ArrayList[r][c];
        initBag(mat,bags,r,c);

        return res;
    }

    private void bfs(Point[][] mat,ArrayList<Point>[][] bags,Point start,int nr,int nc){
        LinkedList<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[nr][nc];
        queue.add(mat[start.x][start.y]);

        visited[start.x][start.y] = true;

        int count = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            int curCnt = 0;
            for (Point p : bags[cur.x][cur.y]){
                if (p.val == 0){
                    min = Math.min(min,count);
                    continue;
                }
                if (!visited[p.x][p.y]){
                    queue.add(p);
                    visited[p.x][p.y] = true;
                    count++;
                }
            }
        }
    }

    private void initBag(Point[][] mat,ArrayList<Point>[][] bags,int r,int c){
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c;j++){
                if (mat[i][j].val != 0){
                    bags[i][j] = new ArrayList<>();
                    if (i+1 < r){//об
                        bags[i][j].add(mat[i+1][j]);
                    }
                    if (i-1 >= 0){
                        bags[i][j].add(mat[i-1][j]);
                    }
                    if (j+1 < c){
                        bags[i][j].add(mat[i][j+1]);
                    }
                    if (j-1 >= 0){
                        bags[i][j].add(mat[i][j-1]);
                    }
                }
            }
        }
    }
}

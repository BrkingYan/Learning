package SwordToOffer.NK66.movingCount;


/*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
* 每一次只能向左，右，上，下四个方向移动一格，
* 但是不能进入行坐标和列坐标的 数位 之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
* */
public class Solution {
    private Location[][] locations;
    private int threshold;

    private int rows;
    private int cols;
    public int movingCount(int threshold, int rows, int cols) {
        locations = new Location[rows][cols];
        generateMap(rows,cols);
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;

        return movingCountAux(locations[0][0]);
    }

    private int movingCountAux(Location current){
        if (current == null || current.sum > threshold || current.visited){
            return 0;
        }
        current.visited = true;
        //至少有自身一个，所以要+1
        return movingCountAux(current.top()) + movingCountAux(current.bottom())
                + movingCountAux(current.left()) + movingCountAux(current.right()) + 1;
    }

    private void generateMap(int rows,int cols){
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                locations[i][j] = new Location(i,j);
            }
        }
    }

    private class Location{
        int x;
        int y;
        int sum;
        boolean visited;
        Location(int x,int y){
            this.x = x;
            this.y = y;
            calSum();
        }

        Location top(){
            if (x-1>=0){
                return locations[x-1][y];
            }
            return null;
        }

        Location bottom(){
            if (x+1<rows){
                return locations[x+1][y];
            }
            return null;
        }

        Location left(){
            if (y-1>=0){
                return locations[x][y-1];
            }
            return null;
        }

        Location right(){
            if (y+1 <cols){
                return locations[x][y+1];
            }
            return null;
        }

        void calSum(){
            sum = 0;
            int tempX = x;
            int tempY = y;
            while (tempX != 0){
                sum += tempX % 10;
                tempX = tempX / 10;
            }
            while (tempY != 0){
                sum += tempY % 10;
                tempY = tempY / 10;
            }
        }

    }
}

package SwordToOffer.NK66.movingCount;


/*
* ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
* ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
* ���ǲ��ܽ����������������� ��λ ֮�ʹ���k�ĸ��ӡ�
* ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
* ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
        //����������һ��������Ҫ+1
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

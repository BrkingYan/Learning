package SwordToOffer.NK65.hasPath;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * */
public class Solution {
    private boolean[] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        int startIndex = 0;
        for (int i = 0;i<matrix.length;i++){
            if (matrix[i] == str[0]){
                startIndex = i;
                visited[startIndex] = true;
                if (hasPathAux(matrix,startIndex,str,0,cols,visited)){
                    return true;
                }
                visited[startIndex] = false;
            }
        }
        return false;
    }

    private boolean hasPathAux(char[] matrix,int start,char[] str,int currentIndex,int col,boolean[] visited){

        if (currentIndex+1 == str.length){
            return true;
        }



            //向右走
            if ((start%col != col-1 && start+1 < matrix.length) && matrix[start+1] == str[currentIndex+1] && !visited[start+1]){
                visited[start+1] = true;
                currentIndex++;
                return hasPathAux(matrix,start+1,str,currentIndex,col,visited);
            }
            //向下走
            if ((start+col < matrix.length) && matrix[start+col] == str[currentIndex+1] && !visited[start+col]){
                visited[start+col] = true;
                currentIndex++;
                return hasPathAux(matrix,start+col,str,currentIndex,col,visited);
            }
            //向左
            if (((start-1)%col != col-1 && start-1 >= 0) && matrix[start-1] == str[currentIndex+1] && !visited[start-1]){
                visited[start-1] = true;
                currentIndex++;
                return hasPathAux(matrix,start-1,str,currentIndex,col,visited);
            }
            //向上
            if ((start-col >= 0) && matrix[start-col] == str[currentIndex+1] && !visited[start-col]){
                visited[start-col] = true;
                currentIndex++;
                return hasPathAux(matrix,start-col,str,currentIndex,col,visited);
            }


        //visited.pop();
        return false;
    }
}

package SwordToOffer.NK65.hasPath;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ�
 * ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·����
 * ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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



            //������
            if ((start%col != col-1 && start+1 < matrix.length) && matrix[start+1] == str[currentIndex+1] && !visited[start+1]){
                visited[start+1] = true;
                currentIndex++;
                return hasPathAux(matrix,start+1,str,currentIndex,col,visited);
            }
            //������
            if ((start+col < matrix.length) && matrix[start+col] == str[currentIndex+1] && !visited[start+col]){
                visited[start+col] = true;
                currentIndex++;
                return hasPathAux(matrix,start+col,str,currentIndex,col,visited);
            }
            //����
            if (((start-1)%col != col-1 && start-1 >= 0) && matrix[start-1] == str[currentIndex+1] && !visited[start-1]){
                visited[start-1] = true;
                currentIndex++;
                return hasPathAux(matrix,start-1,str,currentIndex,col,visited);
            }
            //����
            if ((start-col >= 0) && matrix[start-col] == str[currentIndex+1] && !visited[start-col]){
                visited[start-col] = true;
                currentIndex++;
                return hasPathAux(matrix,start-col,str,currentIndex,col,visited);
            }


        //visited.pop();
        return false;
    }
}

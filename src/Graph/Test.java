package Graph;




/*
* 不管是DFS还是BFS，在搜索中我们都是先将起点存入数据结构中，然后重复以下步骤：直到数据结构被清空
* 1、取出其中一个顶点V 并标记
* 2、将V 的所有“相邻的”“未被标记的”顶点加入数据结构
*
*
*        g1:     0
*              /  \
*             4    1
*              \  /  \
*               3    2
*
*        g2:        0
*                    \
*                     1
*                      \
*                        2
*
* */

import Graph.DFS_Apps.Cycle;
import Graph.DFS_Apps.FindSubGraph;

public class Test {
    public static void main(String[] args) {
        MyGraph g = new MyGraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,4);
        g.addEdge(1,3);
        g.addEdge(4,3);
        System.out.println(g);


        /******************** DFS Test ********************/
        DFS dfs = new DFS(g,0);
        for (int i = 0;i<dfs.getTotal();i++){
            System.out.print(0 + " to " + i + ": ");
            if (dfs.hasPathTo(i)){
                for (int vertex : dfs.pathTo(i)){
                    if (vertex == 0){
                        System.out.print(vertex);
                    }else {
                        System.out.print("-");
                        System.out.print(vertex);
                    }
                }
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        /******************** BFS Test ********************/
        BFS bfs = new BFS(g,0);
        for (int i = 0;i<bfs.getTotal();i++){
            System.out.print(0 + " to " + i + ": ");
            if (bfs.hasPathTo(i)){
                for (int vertex : bfs.pathTo(i)){
                    if (vertex == 0){
                        System.out.print(vertex);
                    }else {
                        System.out.print("-");
                        System.out.print(vertex);
                    }
                }
                System.out.println();
            }
        }

        System.out.println("-----------------------------------------------------------------------------");
        /******************** DFS Cycle Test ********************/
        MyGraph g2 = new MyGraph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        Cycle c = new Cycle(g2);
        System.out.println(c.hasCycle());


        System.out.println("-----------------------------------------------------------------------------");
        /******************** DFS isConnected Test ********************/
        MyGraph g3 = new MyGraph(13);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,5);
        g3.addEdge(0,6);
        g3.addEdge(3,5);
        g3.addEdge(3,4);
        g3.addEdge(4,5);
        g3.addEdge(4,6);
        g3.addEdge(7,8);
        g3.addEdge(9,10);
        g3.addEdge(9,11);
        g3.addEdge(9,12);
        g3.addEdge(11,12);

        FindSubGraph findSubGraph = new FindSubGraph(g3,1);
        System.out.println(findSubGraph.isConnected(0,3));
        System.out.println(findSubGraph.pathTo(3));
        System.out.println(findSubGraph.pathToRange(1,3));

        System.out.println("-----------------------------------------------------------------------------");
        /******************** DFS isConnected Test ********************/


    }
}

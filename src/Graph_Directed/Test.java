package Graph_Directed;

import Graph_Directed.DFSApps.Cycle;

import java.util.Objects;

/*
*  有向图测试
* */
public class Test {
    public static void main(String[] args) {
        MyGraph d_graph = new MyGraph(13);
        d_graph.addEdge(0,1);
        d_graph.addEdge(0,5);
        d_graph.addEdge(2,0);
        d_graph.addEdge(2,3);
        d_graph.addEdge(3,2);
        d_graph.addEdge(3,5);
        d_graph.addEdge(4,2);
        d_graph.addEdge(4,3);
        d_graph.addEdge(5,4);
        d_graph.addEdge(6,0);
        d_graph.addEdge(6,4);
        d_graph.addEdge(6,9);
        d_graph.addEdge(7,6);
        d_graph.addEdge(7,8);
        d_graph.addEdge(8,7);
        d_graph.addEdge(8,9);
        d_graph.addEdge(9,10);
        d_graph.addEdge(9,11);
        d_graph.addEdge(10,12);
        d_graph.addEdge(11,4);
        d_graph.addEdge(11,12);
        d_graph.addEdge(12,9);

        /******************* DFS Test ***************************/
        System.out.println("******************* DFS Test ***************************");
        DFS dfs = new DFS(d_graph,0);
        dfs.dfs(0);
        System.out.println(dfs.pathTo(7));
        System.out.println(dfs.pathTo(4));

        dfs.reset(2);
        dfs.dfs(2);
        System.out.println(dfs.pathTo(4));


        /******************* BFS Test ***************************/
        System.out.println("******************* BFS Test ***************************");
        BFS bfs = new BFS(d_graph,0);
        bfs.bfs();
        System.out.println(bfs.pathTo(2));


        /******************** Cycle Test ********************/
        System.out.println("******************* Cycle Test ***************************");
        MyGraph graph = new MyGraph(5);
        graph.addEdge(0,4);
        graph.addEdge(4,3);
        graph.addEdge(3,2);
        graph.addEdge(2,4);
        graph.addEdge(2,1);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        Cycle cycle = new Cycle(d_graph);
        //System.out.println(cycle.hasCycle());
        //System.out.println(cycle.getCircleNum());
        System.out.println(cycle.getCycles());

        /******************** Pre Post Reverse Test ********************/

        /*
        * 有向无环图的逆后序就是拓扑排序
        *
        * 有向环的检测是逆后序的前提
        * */
        System.out.println("******************* Pre Post Reverse Test ***************************");

        MyGraph g3 = new MyGraph(13);

        g3.addEdge(0,6);
        g3.addEdge(0,1);
        g3.addEdge(0,5);
        g3.addEdge(2,0);
        g3.addEdge(2,3);
        g3.addEdge(3,5);
        g3.addEdge(5,4);
        g3.addEdge(6,4);
        g3.addEdge(6,9);
        g3.addEdge(7,6);
        g3.addEdge(8,7);
        g3.addEdge(9,11);
        g3.addEdge(9,10);
        g3.addEdge(9,12);
        g3.addEdge(11,12);

        PrePostReverse prePostReverse = new PrePostReverse(g3);
        System.out.println(prePostReverse.getPre());
        System.out.println(prePostReverse.getPost());
        System.out.println(prePostReverse.getReversePost());
    }
}

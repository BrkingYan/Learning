package Graph_Weighted;


/*
* 图的生成树是一个含有所有顶点的无环子图
*
* MST 最小生成树：一个加权图的最小生成树是它的一棵权值最小的生成树
* Prim算法和Kruskal算法是两种计算MST的经典算法
*
*       计算原理：1、用一条边连接树的任意两个顶点都会产生一个新的环
*                 2、从树中删去一条边将会得到两棵独立的树
*       利用切分定理：在一个加权图中，给定任意的切分，它的所有横切边中的权重最小者必定属于最小生成树
*
*       所有计算最小生成树的算法都是 贪心算法 的特殊情况。
*
*       贪心算法：使用切分定理找到最小生成树的一条边，不断重复，直到找到最小生成树的所有边。
*                 各种算法的不同之处在于，保存切分和判定权重最小的横切边的方式不同
*
*
* */
public class MST {
}

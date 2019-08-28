package Mr.Left.T21.remove_node_by_ratio;


/*
*  如果链表长度为5，a = 1 , b = 4  ratio = a / b
*  如果ratio属于下列范围，则移除对应的节点
*
*  (0,1/4]     1
*  (1/4,2/4]   2
*  (2/4,3/4]   3
*  (3/4,1]     4
*
*  设链表长度为N，给定两数为a,b
*  解法：计算 r = (double)(a * N) / (double)b，然后将r向上取整，取整后的r就是结果，即删除第r个节点
* */
public class Solution {
    public void removeByRatio(){

    }
}

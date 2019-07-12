package search;


/*
哈希表分为两步：1、希函数计算散列值 2、碰撞处理

* 哈希函数将键转换为数组索引
* 哈希函数： 1、除留余数法 ，让整数去除以M，得到的余数就是散列值，M只能取质数，
*            2、如果键是浮点数，就先将浮点数转换为二进制，然后再用除留余数法.
*            3、如果键是字符串，利用charAt方法将每个字符转换为数字，每个字符对应一个非负16位整数
*            4、如果键是自定义类型，并且有 who、when、what三个字段，那么自定义对象的哈希值可以这样计算：
*               int hash = 17;
*               hash = 31 * hash + who.hashCode();
*               hash = 31 * hash + when.hashCode();
*               hash = 31 * hash + what.hashCode();
*               return hash;
*
*            java让所有数据类型都继承了一个可以返回32位比特整数的hashCode()方法
*            hashCode()方法必须和equals()方法一致，
*            若a.equals(b)为真，那么 a.hashCode() == b.hashCode() 一定成立
*            若a.hashCode() == b.hashCode() 那么 a.equals(b)不一定成立
*
*            如果要判断两个对象是否相同，如果先用hashCode()发现相等，还不能断定两个对象相同，
*            此时还得用equals()方法去判断，才能确定两者相同。
*
*            java为多种数据类型重写了hashCode()方法，包括String、Integer、Double、File和Url
*
*  软缓存：由于散列值的计算比较耗时，所以在每个键中用了一个hash字段来保存hashCode()的值，
*          除了第一次调用需要计算之外，后面每次调用直接返回hash
*
*  碰撞处理：1、拉链法   数组里面存链表，每个链表里面存的元素具有相同的索引值(链表-数组)
*            2、线性探测法    (并行数组)
*
*
*
* */
public class HashTable {

}

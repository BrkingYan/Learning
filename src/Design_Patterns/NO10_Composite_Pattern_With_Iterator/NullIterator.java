package Design_Patterns.NO10_Composite_Pattern_With_Iterator;

import java.util.Iterator;


/*
* 什么是Null Iterator：菜单项内没什么可以遍历的，那么我们要如何实现菜单项的createIterator()方法呢？有两种选择：
*选择一：
*       返回null，可以让createIterator()方法返回null，但是如果这么做，我们的客户代码就需要条件语句来判断返回值是否为null
* 选择二：
*       返回一个迭代器，让这个迭代器的hasNext()方法永远返回false
*       这似乎是一个更好的方案，我们创建了一个“没作用”的迭代器
*
* */
public class NullIterator implements Iterator {


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

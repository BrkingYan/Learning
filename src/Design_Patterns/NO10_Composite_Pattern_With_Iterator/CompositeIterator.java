package Design_Patterns.NO10_Composite_Pattern_With_Iterator;

import java.util.*;

/*
* 这是一个MenuComponent外部的迭代器，外部迭代器必须维护它在遍历中的位置，以便外部客户可以通过调用hasNext()和next()来驱动遍历
* 还必须维护composite递归结构的位置，这就是采用 堆栈 数据结构的原因。
* */
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();   //这里用到了堆栈数据结构

    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()){
            return false;   //如果已经空了，就表示已经没有下一个元素了
        }else{
            Iterator iterator = (Iterator)stack.peek();//从堆栈的顶层取出迭代器
            if (!iterator.hasNext()){//然后看看这个迭代器有没有元素
                stack.pop();//如果它没有元素，就把这个迭代器弹出去，然后递归地调用hasNext()
                return hasNext();
            }else {
                return true;//如果它有下一个元素，就返回 true
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()){
            Iterator iterator = (Iterator) stack.peek();
            //如果有下一个，我们就从堆栈中取出目前的迭代器
            MenuComponent component = (MenuComponent) iterator.next();
            //如果元素是一个Menu，我们有了另一个需要被包含进遍历中的composite，所以我们将它丢进堆栈中。不管是不是Menu，都返回该组件
            if (component instanceof Menu){
                stack.push(component.createIterator());
            }
            return component;
        }else{
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args){

    }

    public void testCompositeIterator(MenuComponent component){
        CompositeIterator iterator = new CompositeIterator(component.createIterator());

        while (iterator.hasNext()){
            MenuComponent component1 = (MenuComponent) iterator.next();
        }
    }
}

package ThinkingInJava.ComparableInterface;

import java.util.Comparator;

/*
*  专门为Student准备的自定义比较器类
* */

/*
*  Comparator 位于 java.util包下
*  如果前期类的设计没有考虑到类的Compare问题而没有实现Comparable接口，
*  后期可以通过Comparator接口来实现比较算法进行排序，
*  并且为了使用不同的排序标准做准备，比如：升序、降序
* */


public class StudentComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        }else if (o1.getAge() < o2.getAge()){
            return -1;
        }else if (o1.getAge() == o2.getAge()){
            if (o1.getSalary() > o2.getSalary()){
                return 1;
            }else if (o1.getSalary() < o2.getSalary()){
                return -1;
            }
        }
        return 0;
    }
}

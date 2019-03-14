package myTestBed;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;


    public Employee(String name,double salary,int year,int month,int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return name;
    }


    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double change = salary * byPercent;
        salary = salary + change;

    }

    public boolean equals(Object otherObj){
        //两个引用同一个对象
        if(this == otherObj)
            return true;
        //对象为空
        if(otherObj == null)
            return false;
        //两者不属于同一个类
        if(this.getClass() != otherObj.getClass())
            return false;
        Employee other = (Employee)otherObj;
            return this.name.equals(other.name)&&this.salary == other.salary&&this.hireDay.equals(other.hireDay);
    }

    public int hashCode(){
//        return super.hashCode();  //Object 的hashCode()方法，根据地址判断
        return Objects.hash(name,salary,hireDay);   //重写的hashCode()方法，根据状态判断，这时放到Map中就区分不出来了
//        return (int)salary;
    }

    public String toString(){
        //return super.toString();  //Object的toString()方法，返回类名+地址
        return getClass().getName() + "[name="+this.getName()+"  salary="+this.getSalary()+"  hireDay="+this.getHireDay()+"]";
        //重写的toString()方法，返回 状态
    }
}

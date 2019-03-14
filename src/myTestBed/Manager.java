package myTestBed;

import java.util.Objects;

public class Manager extends Employee {
    private double bonus;


    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public int hashCode(){
        return super.hashCode()+17*new Double(bonus).hashCode();
    }

    public String toString(){
        return super.toString()+"[bonus="+this.bonus+"]";
    }
}

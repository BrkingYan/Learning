package Design_Patterns.NO6_Command_Mode;

public class CeilingFan {
    String location;
    int speed;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    public CeilingFan(String location){
        this.location = location;
        speed = OFF;
    }
    public void high(){
        speed = HIGH;
        System.out.println("fan is on with high speed");
    }

    public void medium(){
        speed = MEDIUM;
        System.out.println("fan is on with medium speed");
    }

    public void low(){
        speed = LOW;
        System.out.println("fan is on with low speed");
    }

    public void off(){
        speed = OFF;
        System.out.println("fan is off");
    }

    public int getSpeed(){
        return speed;
    }
}

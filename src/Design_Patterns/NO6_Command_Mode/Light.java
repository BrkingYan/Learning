package Design_Patterns.NO6_Command_Mode;

public class Light {
    String location;
    Light(String location){
        this.location = location;
    }
    public void on(){
        System.out.println(location + " Light is on!");
    }
    public void off(){
        System.out.println(location + " Light is off!");
    }
}

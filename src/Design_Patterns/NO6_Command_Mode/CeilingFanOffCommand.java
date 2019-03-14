package Design_Patterns.NO6_Command_Mode;

public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }


    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH)
            ceilingFan.high();
        else if (prevSpeed == CeilingFan.MEDIUM)
            ceilingFan.medium();
        else if (prevSpeed == CeilingFan.LOW)
            ceilingFan.low();

    }
}

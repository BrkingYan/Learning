package Design_Patterns.NO6_Command_Mode;

public class RemoteLoader {
    public static void main(String[] args){
        /*
        * test the normal remote control
        * */
        //创建遥控器对象
        RemoteControl remoteControl = new RemoteControl();
        //创建家用电器对象
        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        //创建一些命令灯的Command
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        //让0号插槽去控制客厅灯的开关
        remoteControl.setCommands(0,livingRoomLightOn,livingRoomLightOff);
        //让1号插槽去控制厨房灯的开关
        remoteControl.setCommands(1,kitchenLightOn,kitchenLightOff);


        //房屋主人按下按钮去控制灯的开关
        //按下0号插槽的开灯按钮
        remoteControl.onButtonWasPushed(0);
        //按下1号插槽的关灯按钮
        remoteControl.offButtonWasPushed(1);

        remoteControl.offButtonWasPushed(2);


        System.out.println("**************************************************************************");
        /*
        * test the remote control with undo ability
        * */
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        Light classRoomLight = new Light("classroom");
        LightOnCommand classRoomLightOn = new LightOnCommand(classRoomLight);
        LightOffCommand classRoomLightOff = new LightOffCommand(classRoomLight);
        remoteControlWithUndo.setCommands(0,classRoomLightOn,classRoomLightOff);

        Light bedRoomLight = new Light("bed room");
        LightOnCommand bedRoomLightOn = new LightOnCommand(bedRoomLight);
        LightOffCommand bedRoomLightOff = new LightOffCommand(bedRoomLight);
        remoteControlWithUndo.setCommands(1,bedRoomLightOn,bedRoomLightOff);

        CeilingFan ceilingFan = new CeilingFan("living room");
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        remoteControlWithUndo.setCommands(2,ceilingFanHighCommand,ceilingFanOffCommand);

        //remoteControlWithUndo.undoButtonWasPushed();
        remoteControlWithUndo.onButtonWasPushed(0);
        remoteControlWithUndo.undoButtonWasPushed();

        remoteControlWithUndo.offButtonWasPushed(1);
        remoteControlWithUndo.undoButtonWasPushed();

        remoteControlWithUndo.onButtonWasPushed(2);
        //System.out.println(ceilingFan.speed);
        remoteControlWithUndo.undoButtonWasPushed();
        //System.out.println(ceilingFan.speed);

        System.out.println("***********************************************************************");

        /*
        * test of macro command with undo ability
        * */
        Command[] onCommands = {classRoomLightOn,bedRoomLightOn,ceilingFanHighCommand};
        Command[] offCommands = {classRoomLightOff,bedRoomLightOff,ceilingFanOffCommand};
        MacroCommand macroOnCommand = new MacroCommand(onCommands);
        MacroCommand macroOffCommand = new MacroCommand(offCommands);
        remoteControlWithUndo.setCommands(3,macroOnCommand,macroOffCommand);
        remoteControlWithUndo.onButtonWasPushed(3);
        remoteControlWithUndo.undoButtonWasPushed();
    }
}

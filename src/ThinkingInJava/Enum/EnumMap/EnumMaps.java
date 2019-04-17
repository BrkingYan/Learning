package ThinkingInJava.Enum.EnumMap;


import java.util.EnumMap;
import java.util.Map;

import static ThinkingInJava.Enum.EnumMap.AlarmPoints.*;

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> map = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        map.put(KITCHEN, () -> System.out.println("Kitchen fire!"));

        // STAIR�Ǻ�put��ȥ�ģ�������map�л��ǰ���enum�е�˳�����У���put˳���޹�
        map.put(STAIR, new Command() {
            @Override
            public void action() {
                System.out.println("stair fire!");
            }
        });

        for (Map.Entry<AlarmPoints,Command> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

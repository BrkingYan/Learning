package ThinkingInJava.Enum.TypicalEnum;

import ThinkingInJava.IO.OSExecute;
import ThinkingInJava.IO.OSExecuteTest;

public class Test {
    public static void main(String[] args) {
        Color color = Color.GREEN;
        OSExecute.command("javap  Color.class");
    }
}

/*
* Compiled from "Color.java"
final class ThinkingInJava.Enum.TypicalEnum.Color extends java.lang.Enum<ThinkingInJava.Enum.TypicalEnum.Color> {
  public static final ThinkingInJava.Enum.TypicalEnum.Color RED;

  public static final ThinkingInJava.Enum.TypicalEnum.Color YELLOW;

  public static final ThinkingInJava.Enum.TypicalEnum.Color GREEN;

  public static ThinkingInJava.Enum.TypicalEnum.Color[] values();
    Code:
       0: getstatic     #1                  // Field $VALUES:[LThinkingInJava/Enum/TypicalEnum/Color;
       3: invokevirtual #2                  // Method "[LThinkingInJava/Enum/TypicalEnum/Color;".clone:()Ljava/lang/Object;
       6: checkcast     #3                  // class "[LThinkingInJava/Enum/TypicalEnum/Color;"
       9: areturn

  public static ThinkingInJava.Enum.TypicalEnum.Color valueOf(java.lang.String);
    Code:
       0: ldc           #4                  // class ThinkingInJava/Enum/TypicalEnum/Color
       2: aload_0
       3: invokestatic  #5                  // Method java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
       6: checkcast     #4                  // class ThinkingInJava/Enum/TypicalEnum/Color
       9: areturn

  static {};
    Code:
       0: new           #4                  // 实例化RED
       3: dup
       4: ldc           #7                  // String RED
       6: iconst_0
       7: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      10: putstatic     #9                  // Field RED:LThinkingInJava/Enum/TypicalEnum/Color;
      13: new           #4                  // 实例化YELLOW
      16: dup
      17: ldc           #10                 // String YELLOW
      19: iconst_1
      20: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      23: putstatic     #11                 // Field YELLOW:LThinkingInJava/Enum/TypicalEnum/Color;
      26: new           #4                  // 实例化GREEN
      29: dup
      30: ldc           #12                 // String GREEN
      32: iconst_2
      33: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      36: putstatic     #13                 // Field GREEN:LThinkingInJava/Enum/TypicalEnum/Color;
      39: iconst_3
      40: anewarray     #4                  // 创建数组 values[] = new Color[]{RED,YELLOW,GREEN}
      43: dup
      44: iconst_0
      45: getstatic     #9                  // Field RED:LThinkingInJava/Enum/TypicalEnum/Color;
      48: aastore
      49: dup
      50: iconst_1
      51: getstatic     #11                 // Field YELLOW:LThinkingInJava/Enum/TypicalEnum/Color;
      54: aastore
      55: dup
      56: iconst_2
      57: getstatic     #13                 // Field GREEN:LThinkingInJava/Enum/TypicalEnum/Color;
      60: aastore
      61: putstatic     #1                  // color = Color.GREEN
      64: return
}
* */

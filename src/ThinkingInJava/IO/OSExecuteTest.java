package ThinkingInJava.IO;

public class OSExecuteTest {
    public static void main(String[] args) {
        //OSExecute.command("javac OSExecute1.java");
        //OSExecute.command("java OSExecute1");
        //OSExecute.command("javap OSExecute1");
        //OSExecute.command("javap -c OSExecute1");


        OSExecute.commandWithRuntime("java OSExecute1");
    }
}

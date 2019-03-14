package ThinkingInJava.Reflect;

public class AbstractToy implements InterfaceToy {
    @Override
    public String playToy(String player) throws Exception {
        System.out.println(player + " plays abstract toy");
        return "";
    }
}

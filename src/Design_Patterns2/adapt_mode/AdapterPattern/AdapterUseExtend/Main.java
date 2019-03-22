package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseExtend;

public class Main {
    public static void main(String[] args) {
        //现在通过适配器AdapterBanner将横幅显示包装成显示技术，档次就上来了
        DisplayTech tech = new AdaptedBanner("hello world");
        tech.strongDisplay();
        tech.weakDisplay();
    }
}

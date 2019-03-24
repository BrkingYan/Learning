package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseInnerClass;

public class Main {
    public static void main(String[] args) {
        AdaptedBanner adaptedBanner = new AdaptedBanner("hello world");
        adaptedBanner.strongDisplay();
        adaptedBanner.weakDisplay();
    }
}

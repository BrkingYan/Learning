package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseExtend;

public class Main {
    public static void main(String[] args) {
        //����ͨ��������AdapterBanner�������ʾ��װ����ʾ���������ξ�������
        DisplayTech tech = new AdaptedBanner("hello world");
        tech.strongDisplay();
        tech.weakDisplay();
    }
}

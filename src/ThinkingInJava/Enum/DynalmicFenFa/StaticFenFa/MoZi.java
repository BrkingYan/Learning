package ThinkingInJava.Enum.DynalmicFenFa.StaticFenFa;

public class MoZi {

    public void ride(Horse h) {
        System.out.println("Riding a horse");
    }

    public void ride(WhiteHorse wh) {
        System.out.println("Riding a white horse");
    }

    public void ride(BlackHorse bh) {
        System.out.println("Riding a black horse");
    }

    /*
    *  java֧�־�̬��ַ�(���ݾ�̬���Ͷ�ַ�)�����Ƿ���������������(���ж�����ط���)�ͷ���������������
    * */
    public static void main(String[] args) {
        Horse wh = new WhiteHorse(); //�ڱ�����ΪHorse����
        WhiteHorse wh2 = new WhiteHorse();//�ڱ�����ΪWhiteHorse����

        Horse bh = new BlackHorse();//�ڱ�����ΪHorse����
        BlackHorse bh2 = new BlackHorse();//�ڱ�����ΪBlackHorse����

        MoZi mozi = new MoZi();

        mozi.ride(wh);
        mozi.ride(wh2);
        mozi.ride(bh);
        mozi.ride(bh2);
    }
}
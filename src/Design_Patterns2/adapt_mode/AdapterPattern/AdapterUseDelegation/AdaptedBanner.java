package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseDelegation;

//����ί��ʵ������
class AdaptedBanner extends DisplayTech {
    private Banner banner;

    AdaptedBanner(String content){
        banner = new Banner(content);
    }

    @Override
    void weakDisplay() {
        banner.showWithParen();
    }

    @Override
    void strongDisplay() {
        banner.showWithAster();
    }
}

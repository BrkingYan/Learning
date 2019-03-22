package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseDelegation;

class AdaptedBanner extends DisplayTech {
    private Banner banner;

    public AdaptedBanner(String content){
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

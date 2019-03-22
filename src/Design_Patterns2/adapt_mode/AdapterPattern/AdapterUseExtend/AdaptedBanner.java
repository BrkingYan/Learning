package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseExtend;

//适配器类
class AdaptedBanner extends Banner implements DisplayTech {


    public AdaptedBanner(String content) {
        super(content);
    }

    //将()显示法包装成弱显示
    @Override
    public void weakDisplay() {
        showWithParen();
    }

    //将**显示法包装成强显示
    @Override
    public void strongDisplay() {
        showWithAster();
    }
}

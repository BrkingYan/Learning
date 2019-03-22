package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseExtend;

//��������
class AdaptedBanner extends Banner implements DisplayTech {


    public AdaptedBanner(String content) {
        super(content);
    }

    //��()��ʾ����װ������ʾ
    @Override
    public void weakDisplay() {
        showWithParen();
    }

    //��**��ʾ����װ��ǿ��ʾ
    @Override
    public void strongDisplay() {
        showWithAster();
    }
}

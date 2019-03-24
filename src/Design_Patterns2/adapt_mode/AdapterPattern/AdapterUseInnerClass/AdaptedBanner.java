package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseInnerClass;


/*
*  ���ַ�ʽ����������ģʽ��ֻ����һ���ڲ����Demo��
*  ��ΪAdaptedBanner��ʵ��ϸ�������ˣ�����Banner��ķ���Ҳ���ı���
* */
class AdaptedBanner implements DisplayTech{
    private String showString;
    private Banner banner;

    AdaptedBanner(String label){
        showString = label;
        banner = new Banner(showString);
    }

    private class Banner{
        private String content;
        private Banner(String content){
            this.content = content;
        }
        //�����������ʾ��ʽ
        void showWithParen(){
            System.out.println("(" + content + ")");
        }
        void showWithAster(){
            System.out.println("*" + content + "*");
        }
    }

    @Override
    public void weakDisplay() {
        banner.showWithParen();
    }

    @Override
    public void strongDisplay() {
        banner.showWithAster();
    }
}

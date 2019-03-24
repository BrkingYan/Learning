package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseInnerClass;


/*
*  这种方式不算适配器模式，只能算一个内部类的Demo，
*  因为AdaptedBanner将实现细节隐藏了，并且Banner类的方法也被改变了
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
        //横幅有两种显示方式
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

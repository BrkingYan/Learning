package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseDelegation;

// 广告横幅
class Banner {
    private String content;

    Banner(String content){
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

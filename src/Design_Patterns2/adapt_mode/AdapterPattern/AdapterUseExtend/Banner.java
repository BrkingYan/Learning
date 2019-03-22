package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseExtend;


// �����
class Banner {
    private String content;

    public Banner(String content){
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

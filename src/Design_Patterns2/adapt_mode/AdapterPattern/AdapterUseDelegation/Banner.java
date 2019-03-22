package Design_Patterns2.adapt_mode.AdapterPattern.AdapterUseDelegation;

// �����
class Banner {
    private String content;

    Banner(String content){
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

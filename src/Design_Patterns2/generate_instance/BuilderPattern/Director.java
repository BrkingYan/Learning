package Design_Patterns2.generate_instance.BuilderPattern;

class Director {

    //Directorֻ�涨Builder����Ӧ�������£�����֪������builder��ô����
    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("�����絽����");
        builder.makeItems(new String[]{"���Ϻ�","�����"});
        builder.makeString("����");
        builder.makeItems(new String[]{"���Ϻá�","��","�ټ�"});
        builder.builderDone();
    }

}

package Design_Patterns2.generate_instance.BuilderPattern;

class Director {

    //Director只规定Builder类型应该做的事，并不知道具体builder怎么做的
    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从上午到下午");
        builder.makeItems(new String[]{"早上好","下午好"});
        builder.makeString("晚上");
        builder.makeItems(new String[]{"晚上好。","晚安","再见"});
        builder.builderDone();
    }

}

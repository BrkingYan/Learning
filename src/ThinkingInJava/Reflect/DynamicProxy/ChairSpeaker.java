package ThinkingInJava.Reflect.DynamicProxy;

class ChairSpeaker implements Speaker,Leader {
    public void speak(){
        System.out.print("chair man mao says : China NO1");
    }
    @Override
    public void speakString(String s) {
        System.out.print("speak string : " + s);
    }

    @Override
    public String getName() {
        return "chair man mao";
    }

    @Override
    public void command(String people) {
        System.out.print("command " + people + " to do something");
    }
}

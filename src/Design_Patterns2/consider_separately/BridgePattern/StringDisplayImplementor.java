package Design_Patterns2.consider_separately.BridgePattern;

class StringDisplayImplementor implements DisplayImplementor {

    private String content;
    private int contentLength;

    StringDisplayImplementor(String content){
        this.content = content;
        contentLength = content.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + content + "|");
    }

    @Override
    public void rawClose() {
        printLine();
        System.out.println("------------ string end ------------");
    }

    private void printLine(){
        System.out.print("+");
        for (int i = 0;i < contentLength;i ++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}

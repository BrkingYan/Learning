package Design_Patterns2.generate_instance.BuilderPattern;

class TextBuilder extends Builder{
    private StringBuffer buffer;

    TextBuilder(){
        buffer = new StringBuffer();
    }

    @Override
    void makeTitle(String title) {
        buffer.append("==============================\n");
        buffer.append("[").append(title).append("]\n");
    }

    @Override
    void makeString(String content) {
        buffer.append("*").append(content).append("\n");
    }

    @Override
    void makeItems(String[] items) {
        for (String item : items){
            buffer.append("  .").append(item).append("\n");
        }
    }

    @Override
    void builderDone() {
        buffer.append("==============================\n");
    }

    public String getResult(){
        return buffer.toString();
    }
}

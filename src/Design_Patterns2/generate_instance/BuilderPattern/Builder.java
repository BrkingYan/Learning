package Design_Patterns2.generate_instance.BuilderPattern;

abstract class Builder {
    abstract void makeTitle(String title);
    abstract void makeString(String content);
    abstract void makeItems(String[] items);
    abstract void builderDone();
}

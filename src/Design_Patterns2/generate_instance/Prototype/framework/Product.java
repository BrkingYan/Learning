package Design_Patterns2.generate_instance.Prototype.framework;

public interface Product extends Cloneable {
    void work(String mainString);
    Product createClone();
    String getLabel();
    void setLabel(String label);
    void printA1();
}

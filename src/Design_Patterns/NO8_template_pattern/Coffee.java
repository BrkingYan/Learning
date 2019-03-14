package Design_Patterns.NO8_template_pattern;

class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }
    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

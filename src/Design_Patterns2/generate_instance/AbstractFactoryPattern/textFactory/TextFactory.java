package Design_Patterns2.generate_instance.AbstractFactoryPattern.textFactory;


import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;

// 制作页面文本的工厂，但这个工厂可以生产和文本相关的多种Item，并可以进行装配
public class TextFactory extends Factory {

    @Override
    public Link createLink(String description, String url) {
        return new TextLink(description,url);
    }

    @Override
    public Module createModule(String description) {
        return new TextModule(description);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TextPage(title,author);
    }
}

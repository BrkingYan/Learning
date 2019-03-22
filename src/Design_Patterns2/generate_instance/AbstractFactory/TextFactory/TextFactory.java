package Design_Patterns2.generate_instance.AbstractFactory.TextFactory;


import Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory.*;

// 制作页面文本的工厂
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

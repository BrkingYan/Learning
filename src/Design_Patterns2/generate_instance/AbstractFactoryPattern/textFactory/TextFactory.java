package Design_Patterns2.generate_instance.AbstractFactoryPattern.textFactory;


import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;

// ����ҳ���ı��Ĺ�������������������������ı���صĶ���Item�������Խ���װ��
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

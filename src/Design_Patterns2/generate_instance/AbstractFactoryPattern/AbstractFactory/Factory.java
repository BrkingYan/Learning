package Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory;

public abstract class Factory {
    //静态工厂
    public static Factory getFactory(String className){
        Factory factory = null;
        try {
            //有的做法是不符合开闭原则的（对于扩展是开放的，对于修改是关闭的），因为每次增加新的课程就得修改if else语句，可以用反射 传入类的对象解决
            factory = (Factory) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String description,String url);//创建链接
    public abstract Module createModule(String description);//����ģ��
    public abstract Page createPage(String title,String author);//������ҳ
}

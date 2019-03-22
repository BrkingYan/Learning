package Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory;

public abstract class Factory {
    public static Factory getFactory(String className){
        Factory factory = null;
        try {
            //�Է���ķ�ʽ���ɾ���ʵ��
            factory = (Factory) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String description,String url);
    public abstract Module createModule(String description);
    public abstract Page createPage(String title,String author);
}

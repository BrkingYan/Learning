package Design_Patterns.Effective_Java.No1.ServiceProvider;

public class Test {
    //com.mysql.jdbc.Driver
    public static void main(String[] args){
        try {
            //加载ServiceProvider类，该类中注册了服务提供者
            Class<?> c = Class.forName("Design_Patterns.Effective_Java.No1.ServiceProvider.ServiceProvider");
            Service service = ServiceManager.getService("3");
            service.startService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

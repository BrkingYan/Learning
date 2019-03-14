package Design_Patterns.Effective_Java.No1.ServiceProvider;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 服务提供者具体实现类    用于创建服务，并在静态块中注册服务提供者
class ServiceProvider implements ServiceProviderInterface {

    static{
        ServiceManager.registerDefaultProvider(new ServiceProvider());
    }


    @Override
    public Service createService() {
        return new DatabaseService();
    }
}

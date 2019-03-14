package Design_Patterns.Effective_Java.No1.ServiceProvider;

import java.security.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务具体实现类
class DatabaseService implements Service {

    @Override
    public void startService() {
        System.out.println( this.getClass().getName()+ " : database service started!!!");
    }
}

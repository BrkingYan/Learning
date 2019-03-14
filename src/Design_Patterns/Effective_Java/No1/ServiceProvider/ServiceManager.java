package Design_Patterns.Effective_Java.No1.ServiceProvider;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务管理类 类似于 DriverManager
class ServiceManager {


    private static final Map<String,ServiceProvider> serviceProviders = new ConcurrentHashMap<>();
    private static final String DEFAULT_PROVIDER_NAME = "<def>";

    static{
        serviceProviders.put("1",new ServiceProvider());
        serviceProviders.put("2",new ServiceProvider());
        serviceProviders.put("3",new ServiceProvider());
    }

    public static Service getService(String url){
          return newService(url);
    }

    //provider register API
    public static void registerDefaultProvider(ServiceProvider provider){
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    public static void registerProvider(String providerName,ServiceProvider provider){
        serviceProviders.put(providerName,provider);
    }

    //Service access API
    public static Service newService(){
        return newService(DEFAULT_PROVIDER_NAME);
    }

    public static Service newService(String providerName){

        ServiceProvider p = serviceProviders.get(providerName);
        if (p == null){
            throw new IllegalArgumentException("No Provider registered with : " + providerName);
        }
        //如果p不为null，说明该用户注册过，因此提供服务
        return p.createService();
    }

}

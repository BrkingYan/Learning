package Redis;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.227.130",6379);
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        int i = 0;
        jedis.set("mykey" + i,"hello");
    }

    public interface HH{
        public final int a = 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

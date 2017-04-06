import org.junit.Test;
import redis.clients.jedis.*;
import redis.clients.util.SafeEncoder;

import java.util.*;

/**
 * Created by ieayoio on 2017/3/6.
 * <p>
 * 参考：http://www.tianshouzhi.com/api/tutorials/redis/210
 */
public class RedisTest {

    @Test
    public void typeTest() {
        ShardedJedisPool shardedJedisPool;
        JedisShardInfo jedisShardInfo;
        ShardedJedis shardedJedis;

        JedisPool jedisPool;
        Jedis jedis;

        JedisPoolConfig jedisPoolConfig;

        JedisSentinelPool jedisSentinelPool;

        JedisCluster jedisCluster;

    }


    // 连接到 redis 服务
    @Test
    public void ConnectionTest() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());

    }


    @Test
    public void StringTest() {

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: " + jedis.get("runoobkey"));
    }

    @Test
    public void ListTest() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        jedis.del("tutorial-list");
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redisss");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0, 1000);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }
    }

    @Test
    public void keyTest() {

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        // 获取数据并输出
        Set<String> set = jedis.keys("*");


        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("List of stored keys:: " + iterator.next());
        }
    }

    /**
     * 连接池
     */
    @Test
    public void JedisPoolConfigTest() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();
//        jedis.set("ieayoio2017-03-27","123");
        String value = jedis.get("ieayoio2017-03-27");
        System.out.println(value);
        jedis.close();
        pool.close();
    }


//    /**
//     * 高可用连接
//     */
//    @Test
//    public void JedisSentinelPoolTest() {
//
//        Set<String> sentinels = new HashSet<String>();
//        sentinels.add("127.0.0.1:6379");
////        sentinels.add("172.18.18.208:26379");
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(5);
//        config.setMaxTotal(20);
//        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels, config);
//        Jedis jedis = pool.getResource();
//        jedis.set("jedis", "jedis");
//
//        String s = jedis.get("jedis");
//        System.out.println(s);
//
//
//        jedis.close();
//        pool.close();
//    }


    /**
     * 连接池
     */
    @Test
    public void HashTest() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();
        String key = "user";
        String field_name = "name";
        String field_name_value = "tianshouzhi";
        String field_city = "city";
        String field_city_value = "shanghai";
        jedis.hset(key, field_name, field_name_value);
        jedis.hset(key, field_city, field_city_value);


        Map<String, String> map = jedis.hgetAll(key);
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        jedis.close();
        pool.close();
    }

    //Redis和Java的集合实例
    @Test
    public void testSet() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();

        String key = "set_key";
        String[] members = new String[]{"a", "b", "a", "c"};
        jedis.sadd(key, members);

        Set<String> smembers = jedis.smembers(key);
        for (String string : smembers) {
            System.out.println(string);
        }
        jedis.close();
        pool.close();

    }


    // Redis和Java的集合实例
    @Test
    public void testZSet() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();


        String key = "zset_key";
        Map<String, Double> scoreMembers = new HashMap<String, Double>() {{
            put("tianshouzhi", 1.0);
            put("huhuamin", 3.0);
        }};
        jedis.zadd(key, scoreMembers);


        Set<String> zrange = jedis.zrange(key, 0, 2);

        for (String member : zrange) {
            System.out.println(member);
            System.out.println(jedis.zscore(key, member));
        }
    }

    @Test
    public void transactionTest() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();

        Transaction t = jedis.multi();

        t.set("foo", "bar");
        t.set("foo2", "bar");
        t.set("foo3", "bar");
        t.exec();

        jedis.close();
        pool.close();

    }

    @Test
    public void SafeEncoderTest() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null);
        Jedis jedis = pool.getResource();

        Transaction t = jedis.multi();

        t.set(SafeEncoder.encode("SafeEncoderTest"), SafeEncoder.encode("bar"));
        t.exec();

        jedis.close();
        pool.close();

    }

}

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ieayoio on 2017/3/6.
 */
public class RedisTest {


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
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redisss");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0, 5);
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

}

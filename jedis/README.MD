# 安装redis
1. 下载地址：https://redis.io/download
2. Installation 
```bash
$ wget http://download.redis.io/releases/redis-3.2.8.tar.gz
$ tar xzf redis-3.2.8.tar.gz
$ cd redis-3.2.8
$ make
```
3.服务端运行：src/redis-server
4.客户端
```bash
$ src/redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```

# Java 使用 Redis
参考：http://www.runoob.com/redis/redis-java.html
导入
```groovy
compile group: 'redis.clients', name: 'jedis', version: '2.9.0'
```

```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
</dependency>

```


连接到 redis 服务
import redis.clients.jedis.Jedis;
public class RedisJava {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      //查看服务是否运行
      System.out.println("Server is running: "+jedis.ping());
 }
}
编译以上 Java 程序，确保驱动包的路径是正确的。
$javac RedisJava.java
$java RedisJava
Connection to server sucessfully
Server is running: PONG

Redis Java String Example
Redis Java String(字符串) 实例
import redis.clients.jedis.Jedis;
public class RedisStringJava {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      //设置 redis 字符串数据
      jedis.set("runoobkey", "Redis tutorial");
     // 获取存储的数据并输出
     System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
 }
}
编译以上程序。
$javac RedisStringJava.java
$java RedisStringJava
Connection to server sucessfully
Stored string in redis:: Redis tutorial
Redis Java List(列表) 实例
import redis.clients.jedis.Jedis;
public class RedisListJava {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      //存储数据到列表中
      jedis.lpush("tutorial-list", "Redis");
      jedis.lpush("tutorial-list", "Mongodb");
      jedis.lpush("tutorial-list", "Mysql");
     // 获取存储的数据并输出
     List<String> list = jedis.lrange("tutorial-list", 0 ,5);
     for(int i=0; i<list.size(); i++) {
       System.out.println("Stored string in redis:: "+list.get(i));
     }
 }
}
编译以上程序。
$javac RedisListJava.java
$java RedisListJava
Connection to server sucessfully
Stored string in redis:: Redis
Stored string in redis:: Mongodb
Stored string in redis:: Mysql
Redis Java Keys 实例
import redis.clients.jedis.Jedis;
public class RedisKeyJava {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      
     // 获取数据并输出
     List<String> list = jedis.keys("*");
     for(int i=0; i<list.size(); i++) {
       System.out.println("List of stored keys:: "+list.get(i));
     }
   }
}
编译以上程序。
$javac RedisKeyJava.java
$java RedisKeyJava
Connection to server sucessfully
List of stored keys:: tutorial-name
List of stored keys:: tutorial-list


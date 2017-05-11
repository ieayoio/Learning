package fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ieayoio on 2017/4/10.
 */
public class FastjsonTest {


    @Test
    public void test(){

        Map map =new HashMap<>();

        Map map1 =new HashMap<>();
        map1.put(234,345);

        map.put("123",123);
        map.put(456,"234");
        map.put("45666",map1);
        String s = JSON.toJSONString(map);

        System.out.println(s);
    }
}

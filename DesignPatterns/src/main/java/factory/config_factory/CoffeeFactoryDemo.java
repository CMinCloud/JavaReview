package factory.config_factory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;


//和spring读取xml文件然后通过反射构建对象很类似
public class CoffeeFactoryDemo {
    private static HashMap<String, Object> map = new HashMap<>();


    static {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties")));

        String className;
        try {
            while ((className = br.readLine()) != null) {
                String[] Kv = className.split("=");
//                通过反射构建对象
                Constructor<?> constructor = Class.forName(Kv[1]).getConstructor();
                Object coffee = constructor.newInstance();
                map.put(Kv[0], coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object createCoffee(String name) {
        return map.get(name);
    }
}

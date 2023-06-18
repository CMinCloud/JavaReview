package factory.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;



//和spring读取xml文件然后通过反射构建对象很类似
public class CoffeeFactory {
    private static HashMap<String, Object> map = new HashMap<>();

    static {
//        获取Properties对象，它继承了hashtable
        Properties p = new Properties();
//        调用p对象中的load方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);   // 读入配置文件
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String className = p.getProperty((String) key);
//                通过反射构建对象
                Class<?> aClass = Class.forName(className);
                Object coffee = aClass.newInstance();
//                System.out.println(coffee);
//                存入map
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object createCoffee(String name){
        return map.get(name);
    }
}

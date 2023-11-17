package xxx.xxx.xxx.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计类中所有方法返回值类型的个数
 */
public class ClassMethodTypeCountUtil {
    public static Map<String, Integer> getReturnTypeCount(Class<?> clazz) {
        Map<String, Integer> returnTypeCount = new HashMap<>();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.getName().startsWith("get") && !method.getName().startsWith("set")) {
                // 忽略 getter 和 setter 方法，这样只统计普通方法的返回值类型
                String returnType = method.getReturnType().getName();
                returnTypeCount.put(returnType, returnTypeCount.getOrDefault(returnType, 0) + 1);
            }
        }
        return returnTypeCount;
    }

    /**
     * 传入一个全类名
     * @param className
     */
    public static void printClassMethodTypeCount(String className){
        try {
            Class<?> clazz = Class.forName(className);
            Map<String, Integer> returnTypeCount = getReturnTypeCount(clazz);
            System.out.println( className + "类的统计结果：");
            for (Map.Entry<String, Integer> entry : returnTypeCount.entrySet()) {
                System.out.println( "返回值类型为{"+ entry.getKey() + "}的方法: 共 " + entry.getValue() + " 个");
            }
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}

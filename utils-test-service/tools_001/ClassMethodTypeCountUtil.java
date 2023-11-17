package xxx.xxx.xxx.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计类中所有方法返回值类型的个数
 */
public class ClassMethodTypeCountUtil {
    static class ReturnTypeCountInfo {
        private Map<String, Integer> returnTypeCount = new HashMap<>();
        private int totalMethodCount = 0;

        public Map<String, Integer> getReturnTypeCount() {
            return returnTypeCount;
        }

        public int getTotalMethodCount() {
            return totalMethodCount;
        }

        public void addReturnType(String returnType) {
            returnTypeCount.put(returnType, returnTypeCount.getOrDefault(returnType, 0) + 1);
        }

        public void incrementTotalMethodCount() {
            totalMethodCount++;
        }
    }
    public static ReturnTypeCountInfo getReturnTypeCount(Class<?> clazz) {
        ReturnTypeCountInfo returnTypeCountInfo = new ReturnTypeCountInfo();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.getName().startsWith("get") && !method.getName().startsWith("set")) {
                // 忽略 getter 和 setter 方法，这样只统计普通方法的返回值类型
                String returnType = method.getReturnType().getName();
                returnTypeCountInfo.addReturnType(returnType);
                returnTypeCountInfo.incrementTotalMethodCount();
            }
        }

        return returnTypeCountInfo;
    }
    /**
     * 类的全限定名
     * @param className
     */
    public static void printClassMethodTypeCount(String className){
        try {
            Class<?> clazz = Class.forName(className);
            ReturnTypeCountInfo returnTypeCountInfo = getReturnTypeCount(clazz);
            System.out.println("返回值类型统计结果：");
            for (Map.Entry<String, Integer> entry : returnTypeCountInfo.getReturnTypeCount().entrySet()) {
                System.out.println( "返回值类型为{"+ entry.getKey() + "}的方法：共 " + entry.getValue() + " 个");
            }
            System.out.println("总方法数量: " + returnTypeCountInfo.getTotalMethodCount() + " 个");
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}

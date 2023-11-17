package xxx.xxx.xxx.util;

/**
 * 测试代码运行时间
 */
public class TestCodeRunningSpeedUtil {
    public static long startMilliSecond(){
        long current = System.currentTimeMillis();
        System.out.println("staTime: " + current + " ms");
        return current;
    }
    public static long endMilliSecond(){
        long current = System.currentTimeMillis();
        System.out.println("endTime: " + current + " ms");
        return current;
    }
    public static long startNanSecond(){
        long current = System.nanoTime();
        System.out.println("staTime: " + current + " ns");
        return current;
    }
    public static long endNanSecond(){
        long current = System.nanoTime();
        System.out.println("endTime: " + current + " ns");
        return current;
    }
}

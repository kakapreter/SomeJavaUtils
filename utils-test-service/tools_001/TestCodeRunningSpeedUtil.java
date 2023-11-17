package xxx.xxx.xxx.util;

/**
 * 测试代码运行时间
 */
public class TestCodeRunningSpeedUtil {
    /**
     * 起始毫秒数
     * @return
     */
    public static long startMilliSecond(){
        long current = System.currentTimeMillis();
        System.out.println("staTime: " + current + " ms");
        return current;
    }

    /**
     * 最终毫秒数
     * @return
     */
    public static long endMilliSecond(){
        long current = System.currentTimeMillis();
        System.out.println("endTime: " + current + " ms");
        return current;
    }

    /**
     * 起始纳秒数
     * @return
     */
    public static long startNanSecond(){
        long current = System.nanoTime();
        System.out.println("staTime: " + current + " ns");
        return current;
    }

    /**
     * 最终纳秒数
     * @return
     */
    public static long endNanSecond(){
        long current = System.nanoTime();
        System.out.println("endTime: " + current + " ns");
        return current;
    }
}

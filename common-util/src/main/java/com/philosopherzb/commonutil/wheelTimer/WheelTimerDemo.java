package com.philosopherzb.commonutil.wheelTimer;

import com.philosopherzb.commonutil.async.config.NamedThreadFactory;
import com.philosopherzb.commonutil.util.DateUtils;
import io.netty.util.HashedWheelTimer;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author philosopherZB
 * @date 2022/3/9
 */
public class WheelTimerDemo {

    /**
     * 从配置文件读取任务执行次数
     */
    @Value("${wheelTimerDemo.delayTaskCount}")
    private String delayTaskCount;
    /**
     * 线程池，用于延迟任务
     */
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 10,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(200), new NamedThreadFactory("WheelTimerDemo"), new ThreadPoolExecutor.CallerRunsPolicy());
    /**
     * 时间轮执行延时任务
     */
    private final HashedWheelTimer timer = new HashedWheelTimer();

    public static void main(String[] args) {
        new WheelTimerDemo().test();
    }

    public void test() {
        pool.execute(() -> delayTask(new AtomicInteger(Integer.valueOf(delayTaskCount))));
    }

    /**
     * 时间轮算法实现延时任务
     *
     * @param count 延时任务执行次数
     */
    private void delayTask(AtomicInteger count) {
        timer.newTimeout(timeout -> {
            final String str = "test content";
            // 如果指定时间后，仍未处理结束，则终止并更新记录信息
            if (count.getAndDecrement() <= 0) {
                System.out.println("task end " + str + "----" + DateUtils.dateToStringByDefaultDateFormat(new Date()));
            } else {
                System.out.println(str + "----" + count + "----" + DateUtils.dateToStringByDefaultDateFormat(new Date()));
                delayTask(count);
            }
        }, 5, TimeUnit.SECONDS);
    }
}

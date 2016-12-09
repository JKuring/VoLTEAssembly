import java.net.MalformedURLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by linghang.kong on 2016/8/22.
 */
public class Test {
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private int i = 0;

    public static void main(String[] args) throws MalformedURLException {
        Test test = new Test();
        test.startScheduler();
    }

    private void startScheduler() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                i++;
                System.out.println("启动线程" + i);
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("完成线程" + i);
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);
    }
}

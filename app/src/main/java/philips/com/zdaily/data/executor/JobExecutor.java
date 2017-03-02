package philips.com.zdaily.data.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import philips.com.zdaily.domain.executor.ThreadExecutor;

/**
 * Created by 310199928 on 2017/2/17.
 */


public class JobExecutor implements ThreadExecutor {
    private ThreadPoolExecutor threadPoolExecutor;

    private static JobExecutor jobExecutor;

    private static final int                     CORE_POOL_SIZE  = 3;
    private static final int                     MAX_POOL_SIZE   = 5;
    private static final int                     KEEP_ALIVE_TIME = 120;
    private static final TimeUnit                TIME_UNIT       = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE      = new LinkedBlockingQueue<Runnable>();

    private JobExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
                WORK_QUEUE);
    }

    @Override
    public void execute(Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);

    }

    public static JobExecutor getInstance(){
        if(jobExecutor == null){
            jobExecutor = new JobExecutor();
        }
        return jobExecutor;
    }

}

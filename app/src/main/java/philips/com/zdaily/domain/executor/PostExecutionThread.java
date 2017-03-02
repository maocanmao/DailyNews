package philips.com.zdaily.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}

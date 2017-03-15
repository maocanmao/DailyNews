package philips.com.zdaily.presentation;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import philips.com.zdaily.domain.executor.PostExecutionThread;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

@Singleton
public class UiThread implements PostExecutionThread{
    @Inject
    UiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}

package philips.com.zdaily.presentation;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import philips.com.zdaily.domain.executor.PostExecutionThread;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public class UiThread implements PostExecutionThread{
    static UiThread uiThread ;

    private UiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

    public static UiThread getInstance() {
        if(uiThread == null){
            uiThread = new UiThread();
        }
        return uiThread;
    }
}

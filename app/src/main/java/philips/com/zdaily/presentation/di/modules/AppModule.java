package philips.com.zdaily.presentation.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import philips.com.zdaily.BaseApplication;
import philips.com.zdaily.data.executor.JobExecutor;
import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;
import philips.com.zdaily.presentation.UiThread;

/**
 * Created by Zhou Yang on 2017/3/10.
 */
@Module
public class AppModule {
    private final BaseApplication baseApplication;

    public AppModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.baseApplication;
    }

}

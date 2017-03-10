package philips.com.zdaily.common.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import philips.com.zdaily.data.executor.JobExecutor;
import philips.com.zdaily.presentation.UiThread;

/**
 * Created by Zhou Yang on 2017/3/10.
 */
@Module
public class CommonThreadModule {
    @Provides
    @Singleton
    public JobExecutor provideJobExecutor(){
        return new JobExecutor();
    }

    @Provides
    @Singleton
    public UiThread provideUiThread(){
        return new UiThread();
    }

}

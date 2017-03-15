package philips.com.zdaily.presentation.di.components;

import android.content.Context;

import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;
import philips.com.zdaily.domain.repository.NewsRepository;
import philips.com.zdaily.presentation.view.activity.BaseActivity;
import philips.com.zdaily.presentation.view.activity.MainActivity;
import philips.com.zdaily.presentation.view.activity.NewsDetailActivity;

/**
 * Created by Zhou Yang on 2017/3/10.
 */

public interface AppDaggerGraph {
    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    NewsRepository newsRepository();

    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);
    void inject(NewsDetailActivity newsDetailActivity);
}

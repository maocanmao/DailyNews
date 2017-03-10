package philips.com.zdaily.common.di;

import philips.com.zdaily.presentation.view.activity.MainActivity;
import philips.com.zdaily.presentation.view.activity.NewsDetailActivity;

/**
 * Created by Zhou Yang on 2017/3/10.
 */

public interface AppDaggerGraph {
    void inject(MainActivity mainActivity);
    void inject(NewsDetailActivity newsDetailActivity);
}

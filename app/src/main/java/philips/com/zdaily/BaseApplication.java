package philips.com.zdaily;

import android.app.Application;
import android.content.Context;

import philips.com.zdaily.common.di.AppComponent;
import philips.com.zdaily.common.di.DaggerAppComponent;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public class BaseApplication extends Application {
    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getComponent(Context context) {
        return ((BaseApplication)context.getApplicationContext()).appComponent;
    }
}

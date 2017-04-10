package philips.com.zdaily.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import philips.com.zdaily.R;
import philips.com.zdaily.presentation.di.components.HasComponent;
import philips.com.zdaily.presentation.utils.SharedPreferenceHelper;
import philips.com.zdaily.presentation.view.Constants;

/**
 * Created by Zhou Yang on 2017/2/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        boolean isNightMode = SharedPreferenceHelper.getSharedPreferenceBoolean(getApplicationContext(), Constants.NIGHT_MODE,false);
        setNightMode(isNightMode);
    }

    public abstract void initialize();

    public void showMessageWithSnackBar(View view, int stringResId) {
        Snackbar snackbar = Snackbar.make(view, stringResId, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void navigatorTo(final String activityName, final Intent intent) {
        Class<?> clazz;
        try {
            clazz = Class.forName(activityName);
            if (clazz != null) {
                intent.setClass(this, clazz);
                this.startActivity(intent);
            }
        } catch (ClassNotFoundException ignore) {
            return;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected <T> T getComponent(Class<T> componentType){
        return componentType.cast(((HasComponent<T>) this).getComponent());

    }

    protected void setNightMode(boolean isNightMode){
        if(isNightMode){
            setTheme(R.style.DarkTheme);
        }else{
            setTheme(R.style.LightTheme);
        }
    }

}

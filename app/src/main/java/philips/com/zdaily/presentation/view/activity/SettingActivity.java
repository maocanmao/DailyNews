package philips.com.zdaily.presentation.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import philips.com.zdaily.R;
import philips.com.zdaily.presentation.utils.SharedPreferenceHelper;
import philips.com.zdaily.presentation.view.Constants;

/**
 * Created by Zhou Yang on 2017/4/5.
 */

public class SettingActivity extends BaseActivity {
    @Bind(R.id.toggleNightMode)
    ToggleButton nightModeTb;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private boolean isNightMode;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initialize();
    }

    @Override
    public void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        isNightMode = SharedPreferenceHelper.getSharedPreferenceBoolean(getApplicationContext(),
                Constants.NIGHT_MODE,false);
        nightModeTb.setChecked(isNightMode);

        nightModeTb.setOnCheckedChangeListener((compoundButton, b) -> {
            SharedPreferenceHelper.setSharedPreferenceBoolean(getApplicationContext(),
                    Constants.NIGHT_MODE,nightModeTb.isChecked());
            updateTheme();
        });
    }

    private void updateTheme(){
        if(isNightMode){
            this.setTheme(R.style.LightTheme);
        }else{
            this.setTheme(R.style.DarkTheme);
        }
        recreate();
    }
}

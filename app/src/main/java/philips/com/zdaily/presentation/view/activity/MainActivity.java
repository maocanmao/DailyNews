package philips.com.zdaily.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import philips.com.zdaily.BaseApplication;
import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.presentation.adapter.ZhiHuLatestNewsAdapter;
import philips.com.zdaily.presentation.presenter.ZhiHuNewsPresenter;
import philips.com.zdaily.presentation.view.ActivityNameConstants;
import philips.com.zdaily.presentation.view.Constants;
import philips.com.zdaily.presentation.view.ZhiHuNewsView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ZhiHuNewsView {

    @Bind(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Bind(R.id.slider)
    SliderLayout sliderLayout;

    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    ZhiHuNewsPresenter zhiHuNewsPresenter;

    private ZhiHuLatestNewsAdapter zhiHuLatestNewsAdapter;

    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BaseApplication.getComponent(this).inject(this);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initialize();
    }

    @Override
    public void initialize() {
        zhiHuNewsPresenter.setView(this);
        layoutManager = new LinearLayoutManager(this);
        newsRecyclerView.setLayoutManager(layoutManager);
        zhiHuNewsPresenter.initialize();
        configSwipeLayout();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            navigatorTo(ActivityNameConstants.SettingActivityName,new Intent());
            startActivity(new Intent(this,SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void initNewsList(List<NewsEntity.Story> newsEntityList) {
        zhiHuLatestNewsAdapter = new ZhiHuLatestNewsAdapter(newsEntityList, this, news -> {
            Intent intent = new Intent();
            intent.putExtra(Constants.NEWS_ID, news.getId());
            navigatorTo(ActivityNameConstants.DetailActivityName, intent);
        });
        newsRecyclerView.setAdapter(zhiHuLatestNewsAdapter);
    }

    @Override
    public void initSlidingImage(List<NewsEntity.TopStory> topStories) {
        for (NewsEntity.TopStory topStory : topStories) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView.description(topStory.getTitle())
                    .image(topStory.getImage());
            sliderLayout.addSlider(textSliderView);
        }

    }

    @Override
    public void onRefreshSuccess() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showError(int messageId) {
        showMessageWithSnackBar(coordinatorLayout, messageId);
    }

    @Override
    public Context context() {
        return getApplicationContext();
    }

    private void configSwipeLayout() {
        swipeRefreshLayout.setDistanceToTriggerSync(400);
        swipeRefreshLayout.setProgressViewOffset(false,80,250);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);
        swipeRefreshLayout.setOnRefreshListener(() -> zhiHuNewsPresenter.refreshNewsList());
    }


}

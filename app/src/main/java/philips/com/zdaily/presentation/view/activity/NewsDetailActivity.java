package philips.com.zdaily.presentation.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzhoujay.richtext.RichText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import philips.com.zdaily.BaseApplication;
import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.presentation.presenter.NewsDetailPresenter;
import philips.com.zdaily.presentation.view.Constants;
import philips.com.zdaily.presentation.view.NewsDetailView;

public class NewsDetailActivity extends BaseActivity implements NewsDetailView {
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.image)
    ImageView image;

    @Bind(R.id.content)
    TextView content;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Inject
    NewsDetailPresenter newsDetailPresenter;

    private String newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        BaseApplication.getComponent(this).inject(this);
        setSupportActionBar(toolbar);
        initialize();
    }

    @Override
    public void initialize() {
        newsDetailPresenter.setView(this);
        this.newsId = getIntent().getStringExtra(Constants.NEWS_ID);
        newsDetailPresenter.loadNewsDetail(newsId);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }


    @Override
    public void onLoadedNewsDetail(NewsDetail newsDetail) {
        collapsingToolbarLayout.setTitle(newsDetail.getTitle());
        title.setText(newsDetail.getTitle());
        Picasso.with(this).load(newsDetail.getImage()).into(image);
        RichText.from(newsDetail.getBody()).into(content);

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

    }

    @Override
    public Context context() {
        return null;
    }

}

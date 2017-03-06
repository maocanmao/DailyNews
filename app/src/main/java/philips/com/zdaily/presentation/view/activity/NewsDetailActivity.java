package philips.com.zdaily.presentation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import philips.com.zdaily.R;
import philips.com.zdaily.data.executor.JobExecutor;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.data.repository.NewsDataRepository;
import philips.com.zdaily.domain.interactor.GetNewsDetailsInteractor;
import philips.com.zdaily.domain.repository.NewsRepository;
import philips.com.zdaily.presentation.UiThread;
import philips.com.zdaily.presentation.presenter.NewsDetailPresenter;
import philips.com.zdaily.presentation.view.NewsDetailView;

public class NewsDetailActivity extends BaseActivity implements NewsDetailView{
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.content)
    TextView content;

    NewsDetailPresenter newsDetailPresenter;

    private NewsRepository newsRepository;

    private String newsId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
    }

    @Override
    public void initialize() {
        newsRepository = new NewsDataRepository();
        newsDetailPresenter = new NewsDetailPresenter(this, new GetNewsDetailsInteractor(JobExecutor.getInstance(),
                UiThread.getInstance(),newsRepository));
        newsDetailPresenter.loadNewsDetail(newsId);

    }


    @Override
    public void loadNewsDetail(NewsDetail newsDetail) {
        title.setText(newsDetail.getTitle());
        Picasso.with(this).load(newsDetail.getImage()).into(image);
        content.setText(Html.fromHtml(newsDetail.getBody()));
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

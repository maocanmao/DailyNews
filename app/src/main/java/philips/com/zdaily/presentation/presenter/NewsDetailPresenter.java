package philips.com.zdaily.presentation.presenter;

import io.reactivex.observers.DisposableObserver;
import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.domain.interactor.GetNewsDetailsInteractor;
import philips.com.zdaily.presentation.view.NewsDetailView;

/**
 * Created by Zhou Yang on 2017/3/6.
 */

public class NewsDetailPresenter implements Presenter {
    private NewsDetailView newsDetailView;

    private GetNewsDetailsInteractor getNewsDetailsInteractor;

    public NewsDetailPresenter(NewsDetailView newsDetailView, GetNewsDetailsInteractor getNewsDetailsInteractor) {
        this.newsDetailView = newsDetailView;
        this.getNewsDetailsInteractor = getNewsDetailsInteractor;
    }

    public void loadNewsDetail(String newsId){
        showViewLoading();
        getNewsDetail(newsId);
    }

    private void getNewsDetail(String newsId){
        getNewsDetailsInteractor.execute(new DisposableObserver<NewsDetail>() {
            @Override
            public void onNext(NewsDetail value) {
                newsDetailView.onLoadedNewsDetail(value);
            }

            @Override
            public void onError(Throwable e) {
                hideViewLoading();
                newsDetailView.showError(R.string.network_error);
                hideViewLoading();
            }

            @Override
            public void onComplete() {
                hideViewLoading();
            }
        },newsId);
    }

    private void showViewLoading() {
        this.newsDetailView.showLoading();
    }

    private void hideViewLoading() {
        this.newsDetailView.hideLoading();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}

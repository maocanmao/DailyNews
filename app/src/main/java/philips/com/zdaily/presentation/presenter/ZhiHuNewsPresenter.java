package philips.com.zdaily.presentation.presenter;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.observers.DisposableObserver;
import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.domain.interactor.GetZhiHuNewsInteractor;
import philips.com.zdaily.presentation.view.ZhiHuNewsView;

/**
 * Created by Zhou Yang on 2017/2/17.
 */
@Singleton
public class ZhiHuNewsPresenter implements Presenter {
    private ZhiHuNewsView zhiHuNewsView;
    private GetZhiHuNewsInteractor getZhiHuNewsInteractor;

    @Inject
    public ZhiHuNewsPresenter(GetZhiHuNewsInteractor getZhiHuNewsInteractor) {
        this.getZhiHuNewsInteractor = getZhiHuNewsInteractor;
    }

    public void initialize() {
        this.loadNewsList();
    }

    private void loadNewsList() {
        showViewLoading();
        getNewsList();
    }

    public void setView(@NonNull ZhiHuNewsView view){
        this.zhiHuNewsView = view;
    }

    private void showViewLoading() {
        this.zhiHuNewsView.showLoading();
    }

    private void hideViewLoading() {
        this.zhiHuNewsView.hideLoading();
    }

    private void getNewsList() {
        getZhiHuNewsInteractor.execute(new DisposableObserver<NewsEntity>() {
            @Override
            public void onNext(NewsEntity value) {
                zhiHuNewsView.initNewsList(value.getStories());
                zhiHuNewsView.initSlidingImage(value.getTop_stories());

            }

            @Override
            public void onError(Throwable e) {
                zhiHuNewsView.showError(R.string.network_error);
                hideViewLoading();
            }

            @Override
            public void onComplete() {
                hideViewLoading();
            }
        }, null);
    }

    public void refreshNewsList() {
        getZhiHuNewsInteractor.execute(new DisposableObserver<NewsEntity>() {
            @Override
            public void onNext(NewsEntity value) {
                zhiHuNewsView.initNewsList(value.getStories());
                zhiHuNewsView.initSlidingImage(value.getTop_stories());
            }

            @Override
            public void onError(Throwable e) {
                zhiHuNewsView.showError(R.string.network_error);
            }

            @Override
            public void onComplete() {
                zhiHuNewsView.onRefreshSuccess();
            }
        }, null);
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

package philips.com.zdaily.presentation.presenter;

import java.util.List;

import io.reactivex.observers.DisposableObserver;
import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.domain.interactor.GetZhiHuNewsInteractor;
import philips.com.zdaily.presentation.view.ZhiHuNewsView;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public class ZhiHuNewsPresenter implements Presenter {
    private ZhiHuNewsView zhiHuNewsView;
    private GetZhiHuNewsInteractor getZhiHuNewsInteractor;

    public ZhiHuNewsPresenter(ZhiHuNewsView zhiHuNewsView,GetZhiHuNewsInteractor getZhiHuNewsInteractor) {
        this.zhiHuNewsView = zhiHuNewsView;
        this.getZhiHuNewsInteractor = getZhiHuNewsInteractor;
    }

    public void initialize() {
        this.loadNewsList();
    }

    private void loadNewsList() {
        showViewLoading();
        getNewsList();

    }

    private void showViewLoading() {
        this.zhiHuNewsView.showLoading();
    }

    private void hideViewLoading() {
        this.zhiHuNewsView.hideLoading();
    }

    private void getNewsList() {
        getZhiHuNewsInteractor.execute(new DisposableObserver<List<NewsEntity.Story>>() {
            @Override
            public void onNext(List<NewsEntity.Story> value) {
                zhiHuNewsView.initNewsList(value);

            }

            @Override
            public void onError(Throwable e) {
                zhiHuNewsView.showError(R.string.network_error);

            }

            @Override
            public void onComplete() {
                hideViewLoading();

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

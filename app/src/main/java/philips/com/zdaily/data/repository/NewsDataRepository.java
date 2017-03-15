package philips.com.zdaily.data.repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.data.repository.datasource.CloudNewsDataStore;
import philips.com.zdaily.data.repository.datasource.NewsDataStore;
import philips.com.zdaily.domain.repository.NewsRepository;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public class NewsDataRepository implements NewsRepository{

    @Inject
    NewsDataRepository() {
    }

    @Override
    public Observable<NewsEntity> latestNews() {
        NewsDataStore newsDataStore = new CloudNewsDataStore();
        return newsDataStore.latestNews();
    }

    @Override
    public Observable<NewsDetail> newsDetail(String newsId) {
        NewsDataStore newsDataStore = new CloudNewsDataStore();
        return  newsDataStore.newsDetail(newsId);
    }
}

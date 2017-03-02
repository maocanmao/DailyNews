package philips.com.zdaily.data.repository.datasource;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.data.net.RestClient;
import philips.com.zdaily.data.net.ZhiHuNewsService;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public class CloudNewsDataStore implements NewsDataStore {

    @Override
    public Observable<NewsEntity> latestNews() {
        return  RestClient.getService(ZhiHuNewsService.class).getLatestNewsList();
    }
}

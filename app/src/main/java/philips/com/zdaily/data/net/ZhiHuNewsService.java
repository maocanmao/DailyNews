package philips.com.zdaily.data.net;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsEntity;
import retrofit2.http.GET;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public interface ZhiHuNewsService {
    @GET("news/latest")
    Observable<NewsEntity> getLatestNewsList();
}

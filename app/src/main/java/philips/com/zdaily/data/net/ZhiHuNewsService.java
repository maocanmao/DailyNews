package philips.com.zdaily.data.net;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.data.model.NewsEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public interface ZhiHuNewsService {
    @GET("news/latest")
    Observable<NewsEntity> getLatestNewsList();

    @GET("news/{newsId}")
    Observable<NewsDetail> getNewsDetail(@Path("newsId") String newsId);
}

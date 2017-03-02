package philips.com.zdaily.data.repository.datasource;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsEntity;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public interface NewsDataStore {
    Observable<NewsEntity> latestNews();
}

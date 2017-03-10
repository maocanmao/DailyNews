package philips.com.zdaily.presentation.view;

import philips.com.zdaily.data.model.NewsDetail;

/**
 * Created by Zhou Yang on 2017/3/6.
 */

public interface NewsDetailView extends LoadDataView{
    void onLoadedNewsDetail(NewsDetail newsDetail);
}

package philips.com.zdaily.presentation.view;

import java.util.List;

import philips.com.zdaily.data.model.NewsEntity;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public interface ZhiHuNewsView extends LoadDataView{

    void initNewsList(List<NewsEntity.Story> newsEntity);
    void initSlidingImage(List<NewsEntity.TopStory> topStories);
    void onRefreshSuccess();
}

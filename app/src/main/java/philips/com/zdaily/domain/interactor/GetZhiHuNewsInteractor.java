package philips.com.zdaily.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;
import philips.com.zdaily.domain.repository.NewsRepository;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public class GetZhiHuNewsInteractor extends Interactor<NewsEntity, Void> {

    private NewsRepository newsRepository;

    @Inject
    public GetZhiHuNewsInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                  NewsRepository newsRepository
    ) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<NewsEntity> buildInteractorObservable(Void aVoid) {
        return newsRepository.latestNews().map(newsEntity -> newsEntity);// = NewsEntity::getStories()
    }
}

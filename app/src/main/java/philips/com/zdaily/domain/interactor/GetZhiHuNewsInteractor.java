package philips.com.zdaily.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsEntity;
import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;
import philips.com.zdaily.domain.repository.NewsRepository;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public class GetZhiHuNewsInteractor extends Interactor<List<NewsEntity.Story>, Void> {

    private NewsRepository newsRepository;

    @Inject
    public GetZhiHuNewsInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                  NewsRepository newsRepository
    ) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<List<NewsEntity.Story>> buildInteractorObservable(Void aVoid) {
        return newsRepository.latestNews().map(newsEntity -> newsEntity.getStories());// = NewsEntity::getStories()
    }
}

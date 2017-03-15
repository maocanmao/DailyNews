package philips.com.zdaily.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import philips.com.zdaily.data.model.NewsDetail;
import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;
import philips.com.zdaily.domain.repository.NewsRepository;

/**
 * Created by Zhou Yang on 2017/3/6.
 */

public class GetNewsDetailsInteractor extends Interactor<NewsDetail, String> {

    private NewsRepository newsRepository;

    @Inject
    public GetNewsDetailsInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                    NewsRepository newsRepository) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<NewsDetail> buildInteractorObservable(String newsId) {
        return newsRepository.newsDetail(newsId).map(newsDetail -> newsDetail);
    }
}

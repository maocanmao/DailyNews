package philips.com.zdaily.common.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import philips.com.zdaily.data.repository.NewsDataRepository;
import philips.com.zdaily.domain.repository.NewsRepository;

/**
 * Created by Zhou Yang on 2017/3/10.
 */

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    public NewsRepository provideNewsDataRepository(){
        return new NewsDataRepository();
    }
}

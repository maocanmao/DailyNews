package philips.com.zdaily.common.di;

import javax.inject.Singleton;

import dagger.Component;
import philips.com.zdaily.common.di.AppDaggerGraph;
import philips.com.zdaily.common.di.CommonThreadModule;
import philips.com.zdaily.common.di.RepositoryModule;

/**
 * Created by Zhou Yang on 2017/3/10.
 */

@Singleton
@Component(modules = {CommonThreadModule.class, RepositoryModule.class})
public interface AppComponent  extends AppDaggerGraph{
}

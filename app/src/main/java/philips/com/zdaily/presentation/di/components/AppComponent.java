package philips.com.zdaily.presentation.di.components;

import javax.inject.Singleton;

import dagger.Component;
import philips.com.zdaily.presentation.di.modules.AppModule;
import philips.com.zdaily.presentation.di.modules.RepositoryModule;

/**
 * Created by Zhou Yang on 2017/3/10.
 */

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent  extends AppDaggerGraph{
}

package philips.com.zdaily.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Zhou Yang on 2017/3/13.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
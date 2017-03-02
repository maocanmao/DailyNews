package philips.com.zdaily.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import philips.com.zdaily.domain.executor.PostExecutionThread;
import philips.com.zdaily.domain.executor.ThreadExecutor;

/**
 * Created by Zhou Yang on 2017/2/20.
 */

public abstract class  Interactor<T, Params> {
    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    private final CompositeDisposable compositeDisposable;

    public Interactor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.compositeDisposable = new CompositeDisposable();
    }


    /**
     * Builds an {@link Observable} which will be used when executing the current {@link Interactor}.
     */
    abstract Observable<T> buildInteractorObservable(Params params);


    public void execute(DisposableObserver<T> observer, Params params) {
        if (observer != null) {
            final Observable<T> observable = this.buildInteractorObservable(params)
                    .subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.getScheduler());
            addDisposable(observable.subscribeWith(observer));
        }
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        if (disposable != null && compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }
    }

}

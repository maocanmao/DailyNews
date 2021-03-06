package philips.com.zdaily.presentation.view;

import android.content.Context;

/**
 * Created by Zhou Yang on 2017/2/17.
 */

public interface LoadDataView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry();

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideRetry();

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);

    void showError(int messageId);

    /**
     * Get a {@link android.content.Context}.
     */
    Context context();
}

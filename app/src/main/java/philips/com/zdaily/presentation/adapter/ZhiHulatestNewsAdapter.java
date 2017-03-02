package philips.com.zdaily.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import philips.com.zdaily.R;
import philips.com.zdaily.data.model.NewsEntity;

/**
 * Created by Zhou Yang on 2017/2/21.
 */

public class ZhiHulatestNewsAdapter extends RecyclerView.Adapter<ZhiHulatestNewsAdapter.ViewHolder> {

    private List<NewsEntity.Story> newsEntities;
    private Context context;

    public ZhiHulatestNewsAdapter(List<NewsEntity.Story> newsEntities, Context context) {
        this.newsEntities = newsEntities;
        this.context = context;
    }

    @Override
    public ZhiHulatestNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.znews_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsEntity.Story news  = newsEntities.get(position);
        holder.title.setText(news.getTitle());
        Picasso.with(context).load(news.getImages().get(0)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return newsEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

}

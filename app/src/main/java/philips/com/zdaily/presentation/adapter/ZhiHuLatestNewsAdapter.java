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

public class ZhiHuLatestNewsAdapter extends RecyclerView.Adapter<ZhiHuLatestNewsAdapter.ViewHolder> {

    private List<NewsEntity.Story> newsEntities;
    private Context context;
    private OnItemClickListener clickListener;

    public ZhiHuLatestNewsAdapter(List<NewsEntity.Story> newsEntities, Context context, OnItemClickListener clickListener) {
        this.newsEntities = newsEntities;
        this.context = context;
        this.clickListener = clickListener;
    }

    @Override
    public ZhiHuLatestNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.znews_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsEntity.Story news  = newsEntities.get(position);
        holder.bind(news,clickListener);

    }

    @Override
    public int getItemCount() {
        return newsEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void bind(final NewsEntity.Story news, final OnItemClickListener listener){
            title.setText(news.getTitle());
            Picasso.with(itemView.getContext()).load(news.getImages().get(0)).into(imageView);
            itemView.setOnClickListener(view -> listener.onClicked(news));

        }
    }

    public interface OnItemClickListener{
        void onClicked(NewsEntity.Story news);
    }

}

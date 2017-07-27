package com.jacksen.newsmodule.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jacksen.baselib.utils.XOnItemClickListener;
import com.jacksen.newsmodule.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by jacksen on 2017/7/27.
 */

public class NewsListAdapter extends RecyclerArrayAdapter<NewsListBean.NewsDataBean> {

    private XOnItemClickListener itemClickListener;

    public NewsListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder viewHolder = new ViewHolder(parent);
        if (itemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(viewHolder.getAdapterPosition() - headers.size());
                    itemClickListener.onItemClick(viewHolder.imageView, viewHolder.getAdapterPosition() - headers.size());
                }
            });
        }
        return viewHolder;
    }

    private class ViewHolder extends BaseViewHolder<NewsListBean.NewsDataBean> {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(ViewGroup itemView) {
            super(itemView, R.layout.item_news_list);
            imageView = $(R.id.news_image);
            textView = $(R.id.news_title);
        }

        @Override
        public void setData(NewsListBean.NewsDataBean data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(data.getImages()[0])
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView);

            textView.setText(data.getTitle());
        }
    }

    public void setItemClickListener(XOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

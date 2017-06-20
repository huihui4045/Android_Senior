package com.huihui.senior.funcation.material.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huihui.senior.R;
import com.huihui.senior.funcation.material.bean.Article;

import java.util.List;

/**
 * Created by gavin
 * Time 2017/6/13  11:39
 * Email:molu_clown@163.com
 */

public class ArticleWithHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> articles;

    private static final int HEADER_TYPE = 0;

    private OnItemClickListener<Article> mClickListener;

    private int[] colors = new int[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.DKGRAY};

    public ArticleWithHeaderAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEADER_TYPE) {

            TextView textView = new TextView(parent.getContext());

            textView.setHeight(100);
            textView.setGravity(Gravity.CENTER);

            return new HeaderViewHolder(textView);

        } else {


            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_material, parent, false);


            return new ArticleViewHolder(itemView);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof ArticleViewHolder) {

            ArticleViewHolder viewHolder = (ArticleViewHolder) holder;

            final Article article = articles.get(position);

            viewHolder.tvTitle.setText(article.getTitle());

            viewHolder.tvAuthor.setText(article.getAuthor());

            viewHolder.tvPublishTime.setText(article.getPublishTime());

            viewHolder.itemView.setBackgroundColor(colors[(int) (Math.random() * 5)]);


           /* ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            layoutParams.height=new Random().nextInt(10)*100+100;

            viewHolder.itemView.setLayoutParams(layoutParams);*/

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null) {

                        mClickListener.onItemClick(article);
                    }
                }
            });
        }

        if (holder instanceof HeaderViewHolder) {

            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;

            viewHolder.tvTitle.setText("这个是HeadView");
        }
    }

    @Override
    public int getItemCount() {
        return articles==null?1:articles.size()+1;
    }

    protected Article getItem(int position) {

        return articles.get(position-1);
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){

            return HEADER_TYPE;
        }else {

            return 1;
        }
    }

    public void setOnItemClickListener(OnItemClickListener<Article> mClickListener) {
        this.mClickListener = mClickListener;
    }

    public interface OnItemClickListener<T> {

        void onItemClick(T t);
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvPublishTime;
        private TextView tvAuthor;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvPublishTime = (TextView) itemView.findViewById(R.id.time);
            tvAuthor = (TextView) itemView.findViewById(R.id.author);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public HeaderViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView;
        }
    }


}

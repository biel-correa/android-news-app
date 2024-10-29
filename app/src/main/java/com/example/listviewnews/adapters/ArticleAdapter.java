package com.example.listviewnews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.listviewnews.ArticleDetailsActivity;
import com.example.listviewnews.R;
import com.example.listviewnews.models.Article;

import java.util.List;

public class ArticleAdapter extends BaseAdapter {
    private final List<Article> items;
    private final LayoutInflater inflater;

    public ArticleAdapter(Context context, List<Article> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Article getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.article_list_item, parent, false);
        }

        Article item = getItem(position);

        RelativeLayout layout = view.findViewById(R.id.card);
        setOnClickListener(view, layout, item);

        TextView title = view.findViewById(R.id.articleTitle);
        title.setText(item.getTitle());

        TextView type = view.findViewById(R.id.articleType);
        type.setText(String.valueOf(item.getType()));

        return view;
    }

    private void setOnClickListener(View view, RelativeLayout layout, Article item) {
        layout.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ArticleDetailsActivity.class);
            intent.putExtra("id", item.getId());
            view.getContext().startActivity(intent);
        });
    }
}

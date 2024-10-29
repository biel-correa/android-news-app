package com.example.listviewnews.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.listviewnews.ArticleDetailsActivity;
import com.example.listviewnews.R;
import com.example.listviewnews.models.Article;

public class LiveArticleFragment extends Fragment {
    private static final String ARG_ARTICLE_ID = "article.id";
    private static final String ARG_ARTICLE_TITLE = "article.title";
    private static final String ARG_ARTICLE_DESCRIPTION = "article.description";

    private int mArticleId;
    private String mArticleTitle;
    private String mArticleDescription;

    public LiveArticleFragment() {
    }

    public static LiveArticleFragment newInstance(Article article) {
        LiveArticleFragment fragment = new LiveArticleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ARTICLE_ID, article.getId());
        args.putString(ARG_ARTICLE_TITLE, article.getTitle());
        args.putString(ARG_ARTICLE_DESCRIPTION, article.getDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mArticleId = getArguments().getInt(ARG_ARTICLE_ID);
            mArticleTitle = getArguments().getString(ARG_ARTICLE_DESCRIPTION);
            mArticleDescription = getArguments().getString(ARG_ARTICLE_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_live_article, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView articleTitle = view.findViewById(R.id.articleTitle);
        TextView articleDescription = view.findViewById(R.id.articleDescription);

        articleTitle.setText(mArticleTitle);
        articleDescription.setText(mArticleDescription);
        setOnClickListener(view);
    }

    private void setOnClickListener(View view) {
        LinearLayout layout = view.findViewById(R.id.live_container);

        layout.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ArticleDetailsActivity.class);
            intent.putExtra("id", mArticleId);
            view.getContext().startActivity(intent);
        });
    }
}
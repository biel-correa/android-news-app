package com.example.listviewnews;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.listviewnews.adapters.ArticleAdapter;
import com.example.listviewnews.fragments.LiveArticleFragment;
import com.example.listviewnews.models.Article;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setLiveArticle();
        setListView();
    }

    private void setListView() {
        ListView list = findViewById(R.id.article_list);
        list.setAdapter(new ArticleAdapter(this, Db.getInstance().getAllArticles()));
    }

    private void setLiveArticle() {
        final Article article = Db.getInstance().getLiveArticle();

        if (article == null) {
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.live_article_container);

        if (!(fragment instanceof LiveArticleFragment)) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.live_article_container, LiveArticleFragment.newInstance(article));
            transaction.commit();
        }
    }
}
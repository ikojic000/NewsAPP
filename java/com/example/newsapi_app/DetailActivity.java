package com.example.newsapi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.newsapi_app.MainActivity.EXTRA_TITLE;
import static com.example.newsapi_app.MainActivity.EXTRA_URL;
import static com.example.newsapi_app.MainActivity.EXTRA_PUBLISHED_AT;
import static com.example.newsapi_app.MainActivity.EXTRA_DESCRIPTION;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String publishedAt = intent.getStringExtra(EXTRA_PUBLISHED_AT);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewTitle = findViewById(R.id.text_view_title_detail);
        TextView textViewPublishedAt = findViewById(R.id.text_view_publishedAt_detail);
        TextView textViewDescription = findViewById(R.id.text_view_description_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewTitle.setText(title);
        textViewPublishedAt.setText(publishedAt);
        textViewDescription.setText(description);


    }
}

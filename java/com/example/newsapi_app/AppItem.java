package com.example.newsapi_app;

import android.accessibilityservice.GestureDescription;

public class AppItem {

    private String mImageUrl;
    private String mTitle;
    private String mPublishedAt;
    private String mDescription;

    public AppItem(String imageUrl, String title, String publishedAt, String description) {
        mImageUrl = imageUrl;
        mTitle = title;
        mPublishedAt = publishedAt;
        mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public String getDescription() {
        return mDescription;
    }
}

package com.example.newsapi_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ItemViewHolder> {

    private Context mContex;
    private ArrayList<AppItem> mItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AppAdapter(Context context, ArrayList<AppItem> exampleList) {
        mContex = context;
        mItemList = exampleList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContex).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        AppItem currentItem = mItemList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String title = currentItem.getTitle();
        String publishedAt = currentItem.getPublishedAt();
        String description = currentItem.getDescription();

        if (description == null)
            description = "This Article does not have a description defined in JSON";


        holder.mTextViewTitle.setText(title);
        // holder.mTextViewPublishedAt.setText(publishedAt);
        // holder.mTextViewDescription.setText(description);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewTitle;
        // public TextView mTextViewPublishedAt;
        // public TextView mTextViewDescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewTitle = itemView.findViewById(R.id.text_view_title);
            // mTextViewPublishedAt = itemView.findViewById(R.id.text_view_publishedAt);
            // mTextViewDescription = itemView.findViewById(R.id.text_view_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }


}



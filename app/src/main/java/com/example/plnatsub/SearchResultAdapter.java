package com.example.plnatsub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {
    private String[] mDataset;
    private ArrayList<SearchData> arrayList;

    public SearchResultAdapter(ArrayList<SearchData> arrayList) {
        this.arrayList = arrayList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_thumbnail;
        protected TextView tv_title;
        protected TextView tv_percent;

        public MyViewHolder(View v) {
            super(v);
            this.iv_thumbnail = (ImageView) v.findViewById(R.id.iv_thumbnail);
            this.tv_title = (TextView) v.findViewById(R.id.tv_title);
            this.tv_percent = (TextView) v.findViewById(R.id.tv_percent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SearchResultAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SearchResultAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 뷰 만들어지는곳
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_search_result, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //생성되는것 연결
        holder.iv_thumbnail.setImageResource(arrayList.get(position).getIv_thumbnail());
        holder.tv_title.setText(mDataset[position]);
        holder.tv_percent.setText(mDataset[position]);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
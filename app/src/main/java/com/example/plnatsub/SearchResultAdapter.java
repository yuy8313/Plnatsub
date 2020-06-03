package com.example.plnatsub;

import android.content.Context;
import android.content.Intent;
import android.icu.text.UFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {
    //private String[] mDataset;
    private ArrayList<SearchData> arrayList;
    private Context context;

    public SearchResultAdapter(ArrayList<SearchData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
    /*
    public SearchResultAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
     */

    // Create new views (invoked by the layout manager)
    @Override
    public SearchResultAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // 뷰 만들어지는곳
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_search_result, parent, false);

        v.setOnClickListener(new View.OnClickListener() { //클릭하면 정보페이지가 나오도록 설계예정
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(parent.getContext(),"이클릭이벤트는 해당 꽃정보와 연결하는 것입니당", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //생성되는것 연결
        Glide.with(holder.itemView).load(arrayList.get(position).getThumbnail())
                .into(holder.iv_thumbnail);
        holder.tv_title.setText(arrayList.get(position).getTitle());
        holder.tv_percent.setText(arrayList.get(position).getPercent());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return (arrayList != null ? arrayList.size() : 0);
        //return (arrayList != null ? 3 : 0); //리스트에 있는 것중 3개만 출력 리스트가 없으면 0개만 출력 : 오류뜸
    }
}
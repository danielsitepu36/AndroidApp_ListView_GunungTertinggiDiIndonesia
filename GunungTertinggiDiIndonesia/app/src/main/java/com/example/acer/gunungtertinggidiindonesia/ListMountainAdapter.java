package com.example.acer.gunungtertinggidiindonesia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMountainAdapter extends RecyclerView.Adapter<ListMountainAdapter.ListViewHolder> {
    private ArrayList<Mountain> listMountain;

    public ListMountainAdapter(ArrayList<Mountain> list) {
        this.listMountain = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_mountain, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Mountain mountain = listMountain.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mountain.getPhoto())
                .apply(new RequestOptions().override(112, 85))
                .into(holder.imgPhoto);
        holder.tvName.setText(mountain.getName());
        holder.tvHeight.setText(mountain.getTinggi());
        holder.tvDesc.setText(mountain.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMountain.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMountain.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvHeight, tvDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvHeight = itemView.findViewById(R.id.tv_item_height);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Mountain mountain);
    }
}

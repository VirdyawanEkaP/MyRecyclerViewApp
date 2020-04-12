package com.example.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myrecyclerview.R;

import java.util.ArrayList;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder> {
    private ArrayList<Mahasiswa> listMahasiswa;
    //tandain, dibawah ini buat click callback
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    //sampe sini

    public ListMahasiswaAdapter(ArrayList<Mahasiswa> list) {
        this.listMahasiswa = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Mahasiswa mahasiswa = listMahasiswa.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mahasiswa.getPhoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.imgPhoto);
        holder.tvName.setText(mahasiswa.getNama());
        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvHp.setText(mahasiswa.getNoHp());
        //click callback jugga
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMahasiswa.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvNim, tvHp;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvNim =itemView.findViewById(R.id.tv_item_detail);
            tvHp = itemView.findViewById(R.id.tv_item_hp);
        }
    }

    //implementasi interface Callback
    public interface OnItemClickCallback {
        void onItemClicked(Mahasiswa data);
    }
}

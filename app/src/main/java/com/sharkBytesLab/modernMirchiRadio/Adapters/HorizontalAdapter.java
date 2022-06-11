package com.sharkBytesLab.modernMirchiRadio.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sharkBytesLab.modernMirchiRadio.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder>{

    int[] images;

    public HorizontalAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);

        return new HorizontalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.ViewHolder holder, int position)
    {

        int image = images[position];

        holder.imageView.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

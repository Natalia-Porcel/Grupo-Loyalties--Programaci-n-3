package com.example.yummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecetasFavoritazAdapter extends RecyclerView.Adapter<RecetasFavoritazAdapter.LikeViewHolder> {
    private Context context;
    private ArrayList<Receta> products;
    private OnLikeClickListener onLikeClickListener;

    public RecetasFavoritazAdapter(Context context, ArrayList<Receta> products) {
        this.context = context;
        this.products = products;
    }

    public void setOnLikeClickListener(OnLikeClickListener onLikeClickListener) {
        this.onLikeClickListener = onLikeClickListener;
    }

    public void updateProducts(ArrayList<Receta> products) {
        this.products = products;
         notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recetas_fav, parent, false);
        return new LikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, final int position) {
        holder.onBind(products.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLikeClickListener.onDeleteItemClick(products.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class LikeViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageButton button;

        public LikeViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tvRecetaName);
            button = itemView.findViewById(R.id.ibDelete);
        }

        public void onBind(Receta receta) {
            textView.setText(receta.getName());
        }
    }
}

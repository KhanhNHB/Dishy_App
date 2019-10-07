package com.example.dishy_app.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy_app.R;
import com.example.dishy_app.models.Dishy;

import java.util.List;

public class RecipeOfChefAdapter extends RecyclerView.Adapter<RecipeOfChefAdapter.ViewHolder> {
    private Context mContext;
    private List<Dishy> mDishyList;

    public RecipeOfChefAdapter(Context mContext, List<Dishy> mDishyList) {
        this.mContext = mContext;
        this.mDishyList = mDishyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recipe_of_chef, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mtxtOrder.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mDishyList != null ? mDishyList.size() : 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mtxtOrder,mtxtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxtOrder = itemView.findViewById(R.id.txt_order_recipe_ca);
        }
    }
}

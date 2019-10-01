package com.example.dishy_app.adaptes;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy_app.R;
import com.example.dishy_app.models.ItemConcern;

import java.util.List;

public class ItemConcernAdapter extends RecyclerView.Adapter<ItemConcernAdapter.ViewHolder> {

    private Context mContext;
    private List<ItemConcern> mItems;

    public ItemConcernAdapter(Context context, List<ItemConcern> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_concern, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemConcern item = mItems.get(position);
        holder.img_food.setImageResource(item.getImg());
        holder.txt_food_name.setText(item.getName());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_food;
        private TextView txt_food_name;

        public ViewHolder(View view) {
            super(view);
            img_food = view.findViewById(R.id.img_food);
            txt_food_name = view.findViewById(R.id.txt_food_name);
            System.out.println(txt_food_name);
        }
    }
}

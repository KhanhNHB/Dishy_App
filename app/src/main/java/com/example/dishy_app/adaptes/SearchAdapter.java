package com.example.dishy_app.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy_app.R;
import com.example.dishy_app.models.ItemsResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<ItemsResult> items;
    private Context context;

    public SearchAdapter(List<ItemsResult> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.result_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameFood.setText(items.get(position).getFoodName());
        holder.likeNumber.setText(items.get(position).getLikeNumber());
        holder.timeNumber.setText(items.get(position).getTime());
        holder.level.setText(items.get(position).getLevel());
        holder.foodType.setText(items.get(position).getFoodType());
        holder.numRecipe.setText(items.get(position).getNumRecipe());
        holder.like.setImageResource(items.get(position).getLike());
        holder.nameLogin.setText(items.get(position).getAccountName());


        Picasso.Builder builder = new Picasso.Builder(context);
        builder.build().load(items.get(position).getImageFood()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageFood);
        builder.build().load(items.get(position).getAvatar()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageFood;
        private TextView nameFood;
        private TextView likeNumber;
        private TextView timeNumber;
        private TextView level;
        private TextView foodType;
        private ImageView avatar;
        private TextView numRecipe;
        private ImageView like;
        private TextView nameLogin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFood = itemView.findViewById(R.id.imageFood);
            nameFood = itemView.findViewById(R.id.nameFood);
            likeNumber = itemView.findViewById(R.id.likeNumber);
            timeNumber = itemView.findViewById(R.id.timeNumber);
            level = itemView.findViewById(R.id.level);
            foodType = itemView.findViewById(R.id.foodType);
            avatar = itemView.findViewById(R.id.avatar);
            numRecipe = itemView.findViewById(R.id.numRecipe);
            like = itemView.findViewById(R.id.like);
            nameLogin = itemView.findViewById(R.id.loginName);
        }
    }

}

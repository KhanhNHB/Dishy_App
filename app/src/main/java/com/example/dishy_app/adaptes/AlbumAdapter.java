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
import com.example.dishy_app.models.Dishy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private Context mContext;
    private List<Dishy> mDishies;

    public AlbumAdapter(Context context, List<Dishy> dishies) {
        mContext = context;
        mDishies = dishies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_saved_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTxtName.setText(mDishies.get(position).getName());
        holder.mTxtTime.setText(mDishies.get(position).getTime());
        holder.mTxtOrderRecipe.setText(String.valueOf(position+1));

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.build()
                .load(mDishies.get(position).getImage())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.mImageFood);
    }

    @Override
    public int getItemCount() {
        return mDishies != null ? mDishies.size() : 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxtName, mTxtTime, mTxtOrderRecipe;
        private ImageView mImageFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtOrderRecipe = itemView.findViewById(R.id.txt_order_recipe_ca);
            mTxtTime = itemView.findViewById(R.id.txt_time);
            mTxtName = itemView.findViewById(R.id.txt_name_recipe_chef);
            mImageFood = itemView.findViewById(R.id.img_recipe_chef);
        }
    }
}

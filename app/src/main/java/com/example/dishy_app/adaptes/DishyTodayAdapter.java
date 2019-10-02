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

public class DishyTodayAdapter extends RecyclerView.Adapter<DishyTodayAdapter.ViewHolder> {
    public interface OnDishyToDayClickListener{
        void onClick(Dishy dishy);
    }
    private Context mContext;
    private List<Dishy> mDishyList;
    private OnDishyToDayClickListener mOnDishyToDayClickListener;

    public void setmOnDishyToDayClickListener(OnDishyToDayClickListener mOnDishyToDayClickListener) {
        this.mOnDishyToDayClickListener = mOnDishyToDayClickListener;
    }

    public DishyTodayAdapter(Context mContext, List<Dishy> mDishyList) {
        this.mContext = mContext;
        this.mDishyList = mDishyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_dishy_today, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTxtName.setText(mDishyList.get(position).getName());
        holder.mTxtTime.setText(mDishyList.get(position).getTime());
        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.build().
                load(mDishyList.get(position).getImage()).error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.mImgFood);
        holder.mImgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnDishyToDayClickListener.onClick(mDishyList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDishyList != null ? mDishyList.size() : 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgFood;
        private TextView mTxtName, mTxtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgFood = itemView.findViewById(R.id.img_dishy_today);
            mTxtName = itemView.findViewById(R.id.txt_name_dishy_today);
            mTxtTime = itemView.findViewById(R.id.txt_time_dishy_today);
        }
    }
}

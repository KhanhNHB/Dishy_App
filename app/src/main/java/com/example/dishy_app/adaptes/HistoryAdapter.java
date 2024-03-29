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
import com.example.dishy_app.models.DataHistory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    Context context;
    List<DataHistory> dataHistoryList;


    public HistoryAdapter(Context context, List<DataHistory> dataHistoryList) {
        this.context = context;
        this.dataHistoryList = dataHistoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView txtNameFood;
        TextView txtLikeNumber;
        TextView txtTimeNumber;
        TextView txtLevel;
        TextView txtStatus;
        TextView txtTime;
        ImageView like;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameFood = (TextView)itemView.findViewById(R.id.nameFood);
            image = (ImageView)itemView.findViewById(R.id.imageFood);
            txtLikeNumber = (TextView)itemView.findViewById(R.id.likeNumber);
            txtTimeNumber = (TextView)itemView.findViewById(R.id.timeNumber);
            txtLevel = (TextView)itemView.findViewById(R.id.level);
            txtStatus = (TextView)itemView.findViewById(R.id.status);
            txtTime = (TextView)itemView.findViewById(R.id.txtTime);

            like = itemView.findViewById(R.id.like);
        }
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_history, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        holder.txtNameFood.setText(dataHistoryList.get(position).getNameFood());
        holder.txtLevel.setText(dataHistoryList.get(position).getLevel());
        holder.txtLikeNumber.setText(dataHistoryList.get(position).getLikeNumber());
        holder.txtTime.setText(dataHistoryList.get(position).getTime());
        holder.txtStatus.setText(dataHistoryList.get(position).getStatus());
        holder.txtTimeNumber.setText(dataHistoryList.get(position).getTimeNumber());
        holder.like.setImageResource(dataHistoryList.get(position).getLike());
       // holder.avatar.setImageResource(dataHistoryList.get(position).getAvatar());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.build().load(dataHistoryList.get(position).getImage())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataHistoryList.size();
    }
}

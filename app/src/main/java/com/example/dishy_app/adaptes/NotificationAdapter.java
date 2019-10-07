package com.example.dishy_app.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy_app.DataNotification;
import com.example.dishy_app.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    List<DataNotification> dataNotifications;
    Context context;

    public NotificationAdapter(List<DataNotification> dataNotifications, Context context) {
        this.dataNotifications = dataNotifications;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtContent.setText(dataNotifications.get(position).getContent());
        holder.txtTime.setText(dataNotifications.get(position).getTime());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.build().load(dataNotifications.get(position).getImg())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return dataNotifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtContent;
        ImageView img;
        TextView txtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtContent = (TextView)itemView.findViewById(R.id.txtContent);
            img = (ImageView)itemView.findViewById(R.id.imgHinh);
            txtTime = (TextView)itemView.findViewById(R.id.txtTime);
        }
    }
}

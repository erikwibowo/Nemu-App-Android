package com.erikwibowo.nemuapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.erikwibowo.nemuapp.R;
import com.erikwibowo.nemuapp.model.ModelUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ModelUser> mItems;

    public AdapterUser(List<ModelUser> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);
        return new AdapterUser.HolderData(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ModelUser md = mItems.get(position);
        final AdapterUser.HolderData holderData = (AdapterUser.HolderData) holder;
        holderData.nama.setText(md.getFirst_name()+" "+md.getLast_name());
        Picasso.get()
                .load(md.getAvatar())
                .placeholder(R.drawable.ic_image_placeholder)
//                .error(R.drawable.user_placeholder_error)
                .into(holderData.avatar);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private class HolderData extends RecyclerView.ViewHolder {
        public TextView nama;
        public ImageView avatar;

        public HolderData(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.nama);
            avatar = (ImageView) view.findViewById(R.id.avatar);
        }
    }
}

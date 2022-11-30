package com.google.a2050531200217_nguyenvankhoa_ktracuoi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.a2050531200217_nguyenvankhoa_ktracuoi.GetSet.TacGia;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.Interface.onClickTacGiaListListener;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.R;

import java.util.ArrayList;

public class TacGiaAdapter extends RecyclerView.Adapter<TacGiaAdapter.TacGiaViewHolder>{

    Context mcontext;
    ArrayList<TacGia> mList;
    onClickTacGiaListListener listener;

    public TacGiaAdapter(Context mcontext, ArrayList<TacGia> mList, onClickTacGiaListListener listener) {
        this.mcontext = mcontext;
        this.mList = mList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public TacGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_row,parent,false);
        return new TacGiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TacGiaViewHolder holder, int position) {
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }
        return 0;
    }

    public class TacGiaViewHolder extends RecyclerView.ViewHolder {
        private TacGia tacGia;
        ImageView imgTacGia;
        TextView name;

        public TacGiaViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickItemTacGia(tacGia);
                }
            });

            imgTacGia = itemView.findViewById(R.id.imgv_tacgia);
            name = itemView.findViewById(R.id.tv_tenTacGia);
        }

        public void bindData(TacGia tacGia){
            this.tacGia = tacGia;
            imgTacGia.setImageResource(tacGia.getHinhAnh());
            name.setText(tacGia.getName());
        }
    }
}

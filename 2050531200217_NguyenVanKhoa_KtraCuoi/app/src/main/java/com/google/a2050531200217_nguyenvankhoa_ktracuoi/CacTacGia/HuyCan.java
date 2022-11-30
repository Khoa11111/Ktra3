package com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.a2050531200217_nguyenvankhoa_ktracuoi.Adapter.TacGiaAdapter;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.GetSet.TacGia;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.Interface.onClickTacGiaListListener;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.R;

import java.util.ArrayList;

public class HuyCan extends AppCompatActivity implements onClickTacGiaListListener {

    RecyclerView recyclerView;
    ArrayList<TacGia> mlist;
    TacGiaAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huycan);

        AnhXa();
        setRecyclerView();
    }

    private void AnhXa(){
        recyclerView = findViewById(R.id.rcv_huycan);
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        mlist = new ArrayList<>();
        mlist.add(new TacGia(R.drawable.tacphamxuandieu,"Thơ Thơ"));
        mlist.add(new TacGia(R.drawable.tacphamxuandieu,"Thơ Thơ"));
        mlist.add(new TacGia(R.drawable.tacphamxuandieu,"Thơ Thơ"));
        mlist.add(new TacGia(R.drawable.tacphamxuandieu,"Thơ Thơ"));
        mlist.add(new TacGia(R.drawable.tacphamxuandieu,"Thơ Thơ"));
        adapter.notifyDataSetChanged();

        adapter = new TacGiaAdapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickItemTacGia(TacGia tacGia) {

    }
}

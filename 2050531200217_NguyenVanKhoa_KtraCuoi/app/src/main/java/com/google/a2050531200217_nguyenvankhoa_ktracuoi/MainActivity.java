package com.google.a2050531200217_nguyenvankhoa_ktracuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.a2050531200217_nguyenvankhoa_ktracuoi.Adapter.TacGiaAdapter;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia.HuyCan;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia.NamCao;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia.NhatANh;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia.Shakespeare;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.CacTacGia.XuanDieu;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.GetSet.TacGia;
import com.google.a2050531200217_nguyenvankhoa_ktracuoi.Interface.onClickTacGiaListListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onClickTacGiaListListener {

    RecyclerView recyclerView;
    ArrayList<TacGia> mlist;
    TacGiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        setRecyclerView();
    }

    private void AnhXa(){
        recyclerView = findViewById(R.id.rcv_tacgiavanhoc);
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        mlist = new ArrayList<>();
        mlist.add(new TacGia(R.drawable.xuandieu,"Xuân Diệu"));
        mlist.add(new TacGia(R.drawable.nguyennhatanh,"Nguyễn Nhật Ánh"));
        mlist.add(new TacGia(R.drawable.huycan,"Huy Cận"));
        mlist.add(new TacGia(R.drawable.namcao,"Nam Cao"));
        mlist.add(new TacGia(R.drawable.shak,"Shakespeare"));
        adapter = new TacGiaAdapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<TacGia> getListNhaVan(){

        adapter.notifyDataSetChanged();
        return mlist;
    }

    @Override
    public void onClickItemTacGia(TacGia tacGia) {
        switch (tacGia.getHinhAnh()) {
            case R.drawable.xuandieu:
                Intent intXuanDieu = new Intent(this, XuanDieu.class);
                startActivity(intXuanDieu);
                break;
            case R.drawable.nguyennhatanh :
                Intent intNhatAnh = new Intent(this, NhatANh.class);
                startActivity(intNhatAnh);
                break;
            case R.drawable.huycan:
                Intent intHuyCan = new Intent(this, HuyCan.class);
                startActivity(intHuyCan);
                break;
            case R.drawable.namcao:
                Intent intNamCao = new Intent(this, NamCao.class);
                startActivity(intNamCao);
                break;
            case R.drawable.shak:
                Intent intShakespeare = new Intent(this, Shakespeare.class);
                startActivity(intShakespeare);
                break;
        }
    }
}
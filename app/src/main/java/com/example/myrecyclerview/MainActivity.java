package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myrecyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMahasiswa;
    private ArrayList<Mahasiswa> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        rvMahasiswa.setHasFixedSize(true);

        list.addAll(MahasiswaData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        ListMahasiswaAdapter listMahasiswaAdapter = new ListMahasiswaAdapter(list);
        rvMahasiswa.setAdapter(listMahasiswaAdapter);

        listMahasiswaAdapter.setOnItemClickCallback(new ListMahasiswaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Mahasiswa data) {
                showSelectedMahasiswa(data);

            }
        });

    }

    private void showSelectedMahasiswa(Mahasiswa mahasiswa) {
        //Toast.makeText(this, "Kamu Memilih" + mahasiswa.getNama(), Toast.LENGTH_SHORT).show();
        Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMahasiswaActivity.class);
        moveWithObjectIntent.putExtra(DetailMahasiswaActivity.EXTRA_MAHASISWA, mahasiswa);
        startActivity(moveWithObjectIntent);
    }
}
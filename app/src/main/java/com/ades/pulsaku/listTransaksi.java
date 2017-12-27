package com.ades.pulsaku;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class listTransaksi extends AppCompatActivity {

    ListView listView;
    dbcon d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaksi);
        d=new dbcon(this);
        load();
    }
    public void load(){
        Cursor cursor = null;
        try {
            cursor = d.readTransaksi();
        } catch (Exception e) {
            Toast.makeText(this,"salah",Toast.LENGTH_LONG).show();
        }
        String[] from = new String[]{"nama", "harga", "jumlah", "total"};
        int[] to = new int[]{R.id.txtlt1, R.id.txtlt2, R.id.txtlt3,R.id.txtlt4};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(listTransaksi.this, R.layout.listtransaksi, cursor, from, to);
        adapter.notifyDataSetChanged();
        listView = (ListView) findViewById(R.id.listTransaksi
        );
        listView.setAdapter(adapter);
    }
}

package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout daftar, calonPeserta, pengumuman;
    TextView txtNama;
    Context mContext;
    BaseApiService mApiService;

    ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponent();

        Intent intent = getIntent();
//        RetrofitClient.NAMA = intent.getStringExtra("result_nama");
//        RetrofitClient.NISN = intent.getStringExtra("result_nisn");
    }

    private void initComponent() {
        daftar = findViewById(R.id.daftar);
        calonPeserta = findViewById(R.id.calonPeserta);
        txtNama = findViewById(R.id.txtNama);

        txtNama.setText(RetrofitClient.NAMA);
        calonPeserta.setOnClickListener(this);
        daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.daftar:
                startActivity(new Intent(getApplicationContext(), DataPendaftaranActivity.class));
                break;
            case  R.id.calonPeserta:
                startActivity(new Intent(getApplicationContext(), CalonPesertaActivity.class));
                break;
        }
    }
}

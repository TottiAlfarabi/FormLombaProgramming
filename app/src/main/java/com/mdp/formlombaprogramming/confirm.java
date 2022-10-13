package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class confirm extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    TextView tvNama, tvJk, tvNowattsaff, tvAlamat, tvTanggal;
    Button btnTanggal, btnConfirm;
    String nama, jk, nowattsaff,alamat, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk= findViewById(R.id.tv_jk);
        tvNowattsaff = findViewById(R.id.tv_no_wangsaf);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);
        btnTanggal = findViewById(R.id.btn_tanggal);
        btnConfirm = findViewById(R.id.btn_konfirm);

        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        nowattsaff = terima.getStringExtra("varNoWattsaff");
        alamat = terima.getStringExtra("varAlamat");
        jk = terima.getStringExtra("varJenisKelamin");

        tvNama.setText(nama);
        tvNowattsaff.setText(nowattsaff);
        tvAlamat.setText(alamat);
        tvJk.setText(jk);


        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalender = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(confirm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month+ 1);
                        String hari = Integer.toString(day);
                        choosenDate = hari + "/" + bulan + "/" + tahun;
                            tvTanggal.setText(choosenDate);
                    }
                },newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH ), newCalender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(confirm.this);
                dialog.setTitle("perhatian");
                dialog.setMessage("Affah Iyyah Datamuh Sudah benar banh????");

                //positifButton

                dialog.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(confirm.this,"Terima Kasih, Pendaftaran Anda Berhasil.",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //Button Negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });






    }
}
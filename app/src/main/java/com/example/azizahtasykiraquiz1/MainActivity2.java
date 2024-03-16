package com.example.azizahtasykiraquiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewNamaPembeli, textViewTipeMember, textViewKodeBarang1, textViewNamaBarang1, textViewKodeBarang2, textViewNamaBarang2, textViewKodeBarang3, textViewNamaBarang3, textViewJumlahBarang, textViewHarga, textViewTotalHarga, textViewDiscountMember, textViewDiscountHarga, textViewJumlahBayar;
    Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inisialisasi TextView
        textViewNamaPembeli = findViewById(R.id.textViewNamaPembeli);
        textViewTipeMember = findViewById(R.id.textViewTipeMember);
        textViewKodeBarang1 = findViewById(R.id.textViewKodeBarang1);
        textViewNamaBarang1 = findViewById(R.id.textViewNamaBarang1);
        textViewKodeBarang2 = findViewById(R.id.textViewKodeBarang2);
        textViewNamaBarang2 = findViewById(R.id.textViewNamaBarang2);
        textViewKodeBarang3 = findViewById(R.id.textViewKodeBarang3);
        textViewNamaBarang3 = findViewById(R.id.textViewNamaBarang3);
        textViewJumlahBarang = findViewById(R.id.textViewJumlahBarang);
        textViewHarga = findViewById(R.id.textViewHarga);
        textViewTotalHarga = findViewById(R.id.textViewTotalHarga);
        textViewDiscountMember = findViewById(R.id.textViewDiscountMember);
        textViewDiscountHarga = findViewById(R.id.textViewDiscountHarga);
        textViewJumlahBayar = findViewById(R.id.textViewJumlahBayar);
        btnShare = findViewById(R.id.button2);

        // Ambil data dari intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nama = extras.getString("Nama");
            String tipeMember = extras.getString("TipeMember");
            String kodeBarang1 = extras.getString("KodeBarang1");
            String kodeBarang2 = extras.getString("KodeBarang2");
            String kodeBarang3 = extras.getString("KodeBarang3");
            String namaBarang1 = extras.getString("NamaBarang1");
            String namaBarang2 = extras.getString("NamaBarang2");
            String namaBarang3 = extras.getString("NamaBarang3");
            int jumlahBarang = extras.getInt("JumlahBarang");
            double harga1 = extras.getDouble("Harga1");
            double harga2 = extras.getDouble("Harga2");
            double harga3 = extras.getDouble("Harga3");
            double totalHarga = extras.getDouble("TotalHarga");
            double discountMember = extras.getDouble("Diskon");
            double totalHargaSetelahDiskon = extras.getDouble("TotalHargaSetelahDiskon");
            double jumlahBayar = extras.getDouble("JumlahBayar");

            DecimalFormat formatter = new DecimalFormat("#,###");

            // Set data ke TextView
            textViewNamaPembeli.setText("Nama Pembeli: " + nama);
            textViewTipeMember.setText("Tipe Member: " + tipeMember);
            textViewKodeBarang1.setText("Kode Barang 1: " + kodeBarang1);
            textViewNamaBarang1.setText("Nama Barang 1: " + namaBarang1);
            textViewKodeBarang2.setText("Kode Barang 2: " + kodeBarang2);
            textViewNamaBarang2.setText("Nama Barang 2: " + namaBarang2);
            textViewKodeBarang3.setText("Kode Barang 3: " + kodeBarang3);
            textViewNamaBarang3.setText("Nama Barang 3: " + namaBarang3);
            textViewJumlahBarang.setText("Jumlah Barang: " + jumlahBarang);
            textViewHarga.setText("Harga Barang 1: Rp " + formatter.format(harga1) + "\nHarga Barang 2: Rp " + formatter.format(harga2) + "\nHarga Barang 3: Rp " + formatter.format(harga3));
            textViewTotalHarga.setText("Total Harga: Rp " + formatter.format(totalHarga));
            textViewDiscountMember.setText("Diskon Member: Rp " + formatter.format(discountMember));
            textViewDiscountHarga.setText("Total Harga Setelah Diskon: Rp " + formatter.format(totalHargaSetelahDiskon));
            textViewJumlahBayar.setText("Jumlah Bayar: Rp " + formatter.format(jumlahBayar));
        }
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND); // Menetapkan tindakan yang akan dilakukan oleh Intent

                // Menggabungkan kedua teks menjadi satu
                String shareText = "Nama Barang: " + textViewNamaPembeli.getText() + "\n" +
                        "Melakukan transaksi sebesar " + textViewJumlahBayar.getText() + " pada AppMob Store";

                intentShare.putExtra(Intent.EXTRA_TEXT, shareText); // Menetapkan ekstra data untuk teks yang akan dibagikan
                intentShare.setType("text/plain"); // Menetapkan tipe data dari ekstra data

                // Memastikan ada aktivitas yang dapat menangani Intent sebelum memulai aktivitas
                if (intentShare.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentShare);
                }
            }
        });

    }
}
package com.example.tugas10recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas10recyclerview.databinding.ActivityDetailMahasiswaBinding

class DetailMahasiswaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMahasiswaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Detail Mahasiswa"
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Ambil objek Mahasiswa dari intent
        val mahasiswa = intent.getSerializableExtra("MAHASISWA_EXTRA") as Mahasiswa

        // Isi tampilan dengan detail Mahasiswa
        with(binding) {
            imgItemPhoto.setImageResource(mahasiswa.imgmahasiswa)
            tvItemNim.text = mahasiswa.nim
            tvItemName.text = mahasiswa.name
            tvItemJurusan.text = mahasiswa.jurusan
            tvItemIpk.text = mahasiswa.ipk.toString()
            tvItemDescription.text = mahasiswa.description

            // Set warna background berdasarkan nilai IPK
            val ipkColor = when {
                mahasiswa.ipk >= 2.0 && mahasiswa.ipk <= 2.75 -> R.color.red
                mahasiswa.ipk > 2.75 && mahasiswa.ipk <= 3.5 -> R.color.green
                mahasiswa.ipk > 3.5 && mahasiswa.ipk <= 4.0 -> R.color.gold
                else -> android.R.color.transparent
            }

            // Ubah warna background
            root.setBackgroundResource(ipkColor)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
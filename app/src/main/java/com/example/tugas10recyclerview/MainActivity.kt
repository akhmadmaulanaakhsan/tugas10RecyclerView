package com.example.tugas10recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas10recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "MyClass"
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterRestaurant = MahasiswaAdapter(generateMahasiswa()) {
                mahasiswa ->
            Toast.makeText(this@MainActivity, "Hei! You clicked on ${mahasiswa.name}",
                Toast.LENGTH_SHORT).show()

            Log.d("MainActivity", "Clicked")
        }
        with(binding) {
            rvMahasiswa.apply{
                adapter = adapterRestaurant
                layoutManager = LinearLayoutManager(this@MainActivity)
                //layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateMahasiswa() : List<Mahasiswa>{
        return listOf(
            Mahasiswa(imgmahasiswa = R.drawable.max, name = "Max Verstappen", jurusan = "Software Engineering", ipk= 3.90, description = "Seorang mahasiswa Software Engineering dengan fokus pada pengembangan aplikasi mobile. Memiliki kemampuan tinggi dalam penggunaan Java dan Kotlin. Berpartisipasi aktif dalam komunitas pengembang dan pernah menjadi pemenang hackathon lokal."),
            Mahasiswa(imgmahasiswa = R.drawable.perez, name = "Sergio Perez", jurusan = "Software Engineering", ipk= 3.81, description="Mahasiswa Software Engineering dengan keahlian dalam pengembangan sistem perangkat lunak. Menguasai beberapa bahasa pemrograman, termasuk Python dan C++. Berkontribusi dalam proyek open source di GitHub."),
            Mahasiswa(imgmahasiswa = R.drawable.lewis, name = "Lewis Hamilton", jurusan = "Software Engineering", ipk = 3.76, description = "Seorang mahasiswa Software Engineering yang ahli dalam desain antarmuka pengguna (UI/UX). Memiliki keterampilan tinggi dalam menggunakan tools desain seperti Adobe XD. Selalu mencari inovasi baru untuk meningkatkan pengalaman pengguna."),
            Mahasiswa(imgmahasiswa = R.drawable.lando, name = "Lando Norris", jurusan = "Software Engineering", ipk = 3.49, description = "Seorang mahasiswa Software Engineering dengan minat khusus dalam pengembangan permainan (game development). Menguasai berbagai bahasa pemrograman seperti Unity dan C#. Selalu bersemangat untuk menciptakan pengalaman bermain yang unik."),
            Mahasiswa(imgmahasiswa = R.drawable.charles, name = "Charles Leclerc", jurusan = "Software Engineering", ipk = 3.23, description = "Mahasiswa Software Engineering dengan fokus pada pengembangan perangkat lunak untuk Internet of Things (IoT). Berpartisipasi aktif dalam kompetisi pengembangan perangkat lunak dan berhasil mendapatkan sertifikasi dalam pengembangan perangkat IoT."),
            Mahasiswa(imgmahasiswa = R.drawable.russel, name = "George Russel", jurusan = "Software Engineering", ipk = 3.0, description = "Pengembang perangkat lunak yang ahli dalam pengembangan aplikasi web dan backend. Terlibat dalam proyek-proyek besar dan memiliki pengalaman dalam manajemen proyek perangkat lunak. Memiliki kemampuan tinggi dalam bahasa pemrograman seperti JavaScript dan Node.js."),
            Mahasiswa(imgmahasiswa = R.drawable.piastri, name = "Oscar Piastri", jurusan = "Software Engineering", ipk = 2.8, description = "Mahasiswa Software Engineering dengan minat dalam pengembangan perangkat lunak untuk kecerdasan buatan. Sering melakukan penelitian untuk mengembangkan solusi baru. Memiliki kemampuan dalam penggunaan Python dan TensorFlow.")
        )
    }

}
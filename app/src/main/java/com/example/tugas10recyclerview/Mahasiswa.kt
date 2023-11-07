package com.example.tugas10recyclerview

import java.io.Serializable

data class Mahasiswa(
    val imgmahasiswa : Int,
    val name : String = "",
    val nim : String = "",
    val jurusan : String = "",
    val ipk : Double = 0.0,
    val description : String = ""
): Serializable


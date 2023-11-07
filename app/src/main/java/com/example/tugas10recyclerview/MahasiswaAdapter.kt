package com.example.tugas10recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas10recyclerview.databinding.ItemMahasiswaBinding

typealias onClickMahasiswa = (Mahasiswa) -> Unit

class MahasiswaAdapter(private val listMahasiswa: List<Mahasiswa>,
                       private val onClickMahasiswa: onClickMahasiswa) :
    RecyclerView.Adapter<MahasiswaAdapter.ItemMahasiswaViewHolder>() {

    inner class ItemMahasiswaViewHolder(private val binding: ItemMahasiswaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data : Mahasiswa) {
            with(binding) {
                imgItemPhoto.setImageResource(data.imgmahasiswa)
                tvItemName.text = data.name
                tvItemNim.text = data.nim
                tvItemJurusan.text = data.jurusan
                tvItemIpk.text = data.ipk.toString()
                tvItemDescription.text = data.description

                itemView.setOnClickListener{
                    onClickMahasiswa(data)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaAdapter.ItemMahasiswaViewHolder {
        val binding =ItemMahasiswaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemMahasiswaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MahasiswaAdapter.ItemMahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }
}
package com.pascal.myquran.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myquran.databinding.ItemQuranBinding
import com.pascal.myquran.model.ResponseListQuran

class AdapterQuran(
    private val data: Array<ResponseListQuran>,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterQuran.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterQuran.ViewHolder {
        val binding = ItemQuranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size ?: 0

    inner class ViewHolder(val binding: ItemQuranBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseListQuran?) {

            binding.nama.text = item?.namaLatin
            binding.ayat.text = "${item?.jumlahAyat} Ayat"
            binding.nomer.text = item?.nomor.toString()
            binding.type.text = item?.tempatTurun
            binding.asma.text = item?.nama

            binding.root.setOnClickListener {
                if (item != null) {
                    itemClick.detail(item)
                }
            }
        }
    }

    interface OnClickListener {
        fun detail(item: ResponseListQuran)
    }

}
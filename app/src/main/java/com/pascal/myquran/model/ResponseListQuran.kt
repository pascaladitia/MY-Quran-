package com.pascal.myquran.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseListQuran(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("nama_latin")
	val namaLatin: String? = null,

	@field:SerializedName("jumlah_ayat")
	val jumlahAyat: Int? = null,

	@field:SerializedName("tempat_turun")
	val tempatTurun: String? = null,

	@field:SerializedName("arti")
	val arti: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("audio")
	val audio: String? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null
) : Parcelable

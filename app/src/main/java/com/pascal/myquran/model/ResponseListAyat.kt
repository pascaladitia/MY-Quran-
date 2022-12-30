package com.pascal.myquran.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseListAyat(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("ayat")
	val ayat: List<AyatItem?>? = null,

	@field:SerializedName("surat_selanjutnya")
	val suratSelanjutnya: SuratSelanjutnya? = null,

	@field:SerializedName("nama_latin")
	val namaLatin: String? = null,

	@field:SerializedName("surat_sebelumnya")
	val suratSebelumnya: Boolean? = null,

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
	val nomor: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class AyatItem(

	@field:SerializedName("ar")
	val ar: String? = null,

	@field:SerializedName("idn")
	val idn: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("surah")
	val surah: Int? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null,

	@field:SerializedName("tr")
	val tr: String? = null
) : Parcelable

@Parcelize
data class SuratSelanjutnya(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("nama_latin")
	val namaLatin: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

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
